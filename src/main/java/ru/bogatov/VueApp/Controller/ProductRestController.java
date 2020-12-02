package ru.bogatov.VueApp.Controller;

import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("")
    public List<Product> getProducts(@RequestParam(defaultValue = "null") String brandName,
                                     @RequestParam(defaultValue = "null") String productType,
                                     @RequestParam(defaultValue = "null") String minPrice,
                                     @RequestParam(defaultValue = "null") String maxPrice,
                                     @RequestParam(defaultValue = "null") String isSale,
                                     @RequestParam(defaultValue = "null") String sort){
        return productService.getWithParam(brandName,productType,minPrice,maxPrice,isSale,sort);

    }

}
