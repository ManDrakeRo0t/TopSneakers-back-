package ru.bogatov.VueApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogatov.VueApp.Entities.User;
import ru.bogatov.VueApp.Services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("basket")
public class BasketController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("add/{id}")
    public String addToBasket(@PathVariable Integer id, Principal usr){
        userService.addToBasket(id,usr.getName(),1);

        return "redirect:http://localhost:8082/product/item/" + id;
    }

}
