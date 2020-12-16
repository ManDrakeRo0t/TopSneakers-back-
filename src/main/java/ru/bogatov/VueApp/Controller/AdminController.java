package ru.bogatov.VueApp.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bogatov.VueApp.Dao.BrandNameRepo;
import ru.bogatov.VueApp.Dao.ProductRepo;
import ru.bogatov.VueApp.Dao.SellingRepo;
import ru.bogatov.VueApp.Entities.DeliverPunct;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Entities.ProductType;
import ru.bogatov.VueApp.Services.CityService;
import ru.bogatov.VueApp.Services.OrderService;
import ru.bogatov.VueApp.Services.ProductService;
import ru.bogatov.VueApp.Services.PunctService;

import java.util.Arrays;

@Controller
@RequestMapping("/administration")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {

    BrandNameRepo brandNameRepo;
    ProductService productService;
    CityService cityService;
    PunctService punctService;
    OrderService orderService;
    SellingRepo sellingRepo;

    public AdminController(BrandNameRepo brandNameRepo, ProductService productService, CityService cityService, PunctService punctService, OrderService orderService, SellingRepo sellingRepo) {
        this.brandNameRepo = brandNameRepo;
        this.productService = productService;
        this.cityService = cityService;
        this.punctService = punctService;
        this.orderService = orderService;
        this.sellingRepo = sellingRepo;
    }

    @GetMapping
    public String getAdminPage(Model model){
        model.addAttribute("sellings",sellingRepo.findAll());
        return "adminsTemplates/adminMainPage";
    }

    @GetMapping("/stat")
    public String aPage(){
        return "a";
    }

    @PostMapping("/punct")
    public String addPunct(DeliverPunct deliverPunct){
        punctService.addPunct(deliverPunct);
        return "redirect:http://localhost:8082/administration/punct";
    }

    @GetMapping("/punct")
    public String getPunctEditor(Model model){
        model.addAttribute("cities",cityService.getAll());
        return "adminsTemplates/adminPunct";
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
        return "redirect:http://localhost:8082/administration/product";
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
