package ru.bogatov.VueApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bogatov.VueApp.Dao.UsersRepo;
import ru.bogatov.VueApp.Entities.Role;
import ru.bogatov.VueApp.Entities.User;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("")
    public List<User> getAllUsers(){
        List<User> l = usersRepo.findAll();
        return l;
    }

    @GetMapping("/principal")
    public User getPrincipal(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = new User();
        for(GrantedAuthority s : authentication.getAuthorities()){
            if(s.getAuthority().equals("ADMIN")) user.setActive(true);
        }
        user.setUsername(authentication.getName());
        return user;
    }
}
