package ru.bogatov.VueApp.Controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bogatov.VueApp.Entities.User;
import ru.bogatov.VueApp.Services.UserService;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration")
    public String getRegistration(){
        return "auth/registration";
    }

    @PostMapping("registration")
    public String postRegistration(User user, Model model){
        if(!user.getPassword().equals(user.getPass2())){
            model.addAttribute("msg","Вы ввели не одинаковые пароли");
            return "auth/registration";
        }
        if(userService.addUser(user)){
            User newUser = userService.getUserByUserName(user.getUsername());
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(newUser,null,newUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/home";
        }else{
            model.addAttribute("msg","Пользователь с такой почтой уже существует");
            return "auth/registration";
        }

    }
}
