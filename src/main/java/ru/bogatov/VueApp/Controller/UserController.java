package ru.bogatov.VueApp.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogatov.VueApp.Entities.User;
import ru.bogatov.VueApp.Services.UserService;
import java.security.Principal;

@Controller
@RequestMapping("/personal")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('USER')")
    public String getPersonal(Principal username,Model model){
        User user = userService.getUserByUserName(username.getName());
        model.addAttribute("user",user);
        model.addAttribute("sellings",user.getSellingList());
        return "personal";
    }

}
