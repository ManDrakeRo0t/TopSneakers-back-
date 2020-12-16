package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.bogatov.VueApp.Dao.BrandNameRepo;
import ru.bogatov.VueApp.Dao.ProductRepo;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Entities.ProductType;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ProductService {

    ProductRepo productRepo;
    BrandNameRepo brandNameRepo;
    PictureService pictureService;

    public ProductService(ProductRepo productRepo, BrandNameRepo brandNameRepo,PictureService pictureService) {
        this.productRepo = productRepo;
        this.brandNameRepo = brandNameRepo;
        this.pictureService = pictureService;
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public List<Product> getRecommendedProducts(Product product){

        return getWithParam(product.getBrandName().getName(),product.getProductType().name(),"",product.getPrice().toString(),"null","null");
    }

    public void addProduct(MultipartFile[] file,Product product){
        product.setBrandName(brandNameRepo.getBrandNameByName(product.getBrand()));
        product.setCreationDate(Calendar.getInstance());
        if(product.getSale() == null) product.setSale(0);
        try{
            product.setPictures(pictureService.saveFiles(file));
        }catch (Exception e){
            e.printStackTrace();
        }
        product.setStatus(true);
        productRepo.save(product);
    }
    
    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public Product getById(Integer id){
        return productRepo.getProductById(id);
    }


    public List<Product> getWithParam(String brandName, String productType, String minPrice, String maxPrice, String isSale, String sort) {
        List<Product> allProducts = getAll();

        ListIterator<Product> listIterator = allProducts.listIterator();
        while(listIterator.hasNext()){
            Product p = listIterator.next();
            if(!brandName.equals("null")){
                if(!p.getBrandName().getName().equals(brandName)){
                    listIterator.remove();
                    continue;
                }
            }
            if(!productType.equals("null")){
                if(!p.getProductType().name().equals(productType)){
                    listIterator.remove();
                    continue;
                }
            }

            if(!minPrice.equals("")){
                if((p.getPrice() < Float.parseFloat(minPrice))){
                    listIterator.remove();
                    continue;
                }
            }

            if(!maxPrice.equals("")){
                if((p.getPrice() > Float.parseFloat(maxPrice))){
                    listIterator.remove();
                    continue;
                }
            }

            if(!isSale.equals("null")){
                if(p.getSale() == 0){
                    listIterator.remove();
                }
            }


        }
        Comparator<Product> comparator ;

        switch (sort){
            case "lessPrice" :
                comparator = ((x,y) -> (int) (x.getPrice() - y.getPrice()));
                break;
            case "maxPrice" :
                comparator = ((x,y) -> (int) (y.getPrice() - x.getPrice()));
                break;
            case "new" :
                comparator = ((x,y) -> (int) getDateDiff(x.getCreationDate(),y.getCreationDate(),TimeUnit.HOURS));
                break;
            default:
                comparator = ((x,y) -> 0);
        }
        allProducts.sort(comparator);
        return allProducts;
    }

    public static long getDateDiff(Calendar date1, Calendar date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTimeInMillis() - date1.getTimeInMillis();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public void editProduct(Integer id, Product product) {
        Product oldProduct = productRepo.getProductById(id);
        oldProduct.setName(product.getName());
        oldProduct.setBrandName(brandNameRepo.getBrandNameByName(product.getBrand()));
        oldProduct.setProductType(product.getProductType());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCount(product.getCount());
        oldProduct.setSale(product.getSale());
        if(product.isStatus()){
            oldProduct.setStatus(true);
        }else{
            oldProduct.setStatus(false);
        }
        productRepo.save(oldProduct);
        
    }
}
