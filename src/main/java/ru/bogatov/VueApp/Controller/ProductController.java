package ru.bogatov.VueApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogatov.VueApp.Dao.BrandNameRepo;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Entities.ProductFilter;
import ru.bogatov.VueApp.Entities.ProductType;
import ru.bogatov.VueApp.Services.ProductService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    BrandNameRepo brandNameRepo;

    public ProductController(ProductService productService, BrandNameRepo brandNameRepo) {
        this.productService = productService;
        this.brandNameRepo = brandNameRepo;
    }

    @GetMapping("/catalog")
    public String getAllProducts(Model model){
        List<Product> productList = productService.getAll();
        model.addAttribute("products",productList);
        model.addAttribute("brands",brandNameRepo.findAll());
        model.addAttribute("types", Arrays.asList(ProductType.values()));
        return "parts/productList";
    }

    @PostMapping("/catalog")
    public String getFilteredProducts(Model model, ProductFilter productFilter){
        List<Product> productList = productService.getWithParam(
                productFilter.getBrandName(),
                productFilter.getProductType(),
                productFilter.getMinPrice(),
                productFilter.getMaxPrice(),
                productFilter.getIsSale(),
                productFilter.getSort()
                );
        model.addAttribute("products",productList);
        model.addAttribute("brands",brandNameRepo.findAll());
        model.addAttribute("types", Arrays.asList(ProductType.values()));
        return "parts/productList";
    }

    @GetMapping("/item/{id}")
    public String getProductById(@PathVariable Integer id,Model model){
        Product product = productService.getById(id);
        if(product == null){
            model.addAttribute("msg","такого продукта не существует");
        }else{
            model.addAttribute("product",product);
        }
        return "parts/product";
    }
}
