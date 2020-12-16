package ru.bogatov.VueApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.Busket;
import ru.bogatov.VueApp.Entities.BusketEntry;
import ru.bogatov.VueApp.Entities.Product;
import ru.bogatov.VueApp.Services.ProductService;
import ru.bogatov.VueApp.Services.UserService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/basket")
public class BasketRestController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @GetMapping("/{username}")
    public Set<BusketEntry> getBasket(@PathVariable String username){
        return userService.getUserByUserName(username).getBusketList().getProducts();
    }

    @PostMapping("")
    public void editBasket(@RequestBody Map<String,String> map){
        String username = map.get("username");
        int count = Integer.parseInt(map.get("count"));
        int id = Integer.parseInt(map.get("id"));
        userService.editBasket(id,username,count);
    }

    @PostMapping("/delete")
    public void deleteBasket(@RequestBody Map<String,String> map){
        String username = map.get("username");
        int id = Integer.parseInt(map.get("id"));
        userService.deleteBasket(username,id);
    }

    @GetMapping("/count/{username}")
    public Integer getCount(@PathVariable String username){
        if(userService.getUserByUserName(username).getBusketList() == null) return 0;
        return userService.getUserByUserName(username).getBusketList().getProducts().size();

    }

    @GetMapping("/total-price/{username}")
    public Integer getTotalPrice(@PathVariable String username){
        int res = 0;
        for(BusketEntry busketEntry : userService.getUserByUserName(username).getBusketList().getProducts()){
            Product product = busketEntry.getProduct();
            res += product.getPrice() / 100 * (100 - product.getSale()) * busketEntry.getCount();
        }
        return res;
    }







}
