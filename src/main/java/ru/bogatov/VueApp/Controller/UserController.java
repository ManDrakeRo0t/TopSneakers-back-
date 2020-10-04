package ru.bogatov.VueApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bogatov.VueApp.Dao.UsersRepo;
import ru.bogatov.VueApp.Entities.User;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UsersRepo usersRepo;

    @GetMapping("")
    public List<User> getAllUsers(){
        List<User> l = usersRepo.findAll();
        return l;
    }
}
