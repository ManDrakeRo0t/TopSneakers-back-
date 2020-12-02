package ru.bogatov.VueApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bogatov.VueApp.Dao.BrandNameRepo;
import ru.bogatov.VueApp.Dao.ProductRepo;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Entities.ProductType;
import ru.bogatov.VueApp.Services.ProductService;

import java.util.Arrays;

@Controller
@RequestMapping("/administration")
public class AdminController {

    BrandNameRepo brandNameRepo;
    ProductService productService;

    public AdminController(BrandNameRepo brandNameRepo, ProductService productService) {
        this.brandNameRepo = brandNameRepo;
        this.productService = productService;
    }

    @GetMapping
    public String getAdminPage(Model model){
        return "adminsTemplates/adminMainPage";
    }



    @GetMapping("/product")
    public String getProductEditor(Model model){
        model.addAttribute("brands",brandNameRepo.findAll());
        model.addAttribute("types", Arrays.asList(ProductType.values()));
        return "adminsTemplates/adminProducts";
    }

    @PostMapping("/product")
    public String addProduct(@RequestParam("file") MultipartFile[] file,Product product){
        productService.addProduct(file,product);
        return "redirect:http://localhost:8082//administration/product";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductPage(@PathVariable Integer id, Model model){
        Product product = productService.getById(id);
        model.addAttribute("brands",brandNameRepo.findAll());
        model.addAttribute("types", Arrays.asList(ProductType.values()));
        model.addAttribute("product",product);
        return "parts/productEditor";
    }

    @PostMapping("/product/edit/{id}")
    public String editProduct(@PathVariable Integer id,Product product){
        productService.editProduct(id,product);
        return "redirect:http://localhost:8082/product/item/{id}";
    }


}
