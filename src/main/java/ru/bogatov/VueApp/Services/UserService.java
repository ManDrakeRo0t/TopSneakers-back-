package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.UsersRepo;
import ru.bogatov.VueApp.Entities.Role;
import ru.bogatov.VueApp.Entities.User;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    public boolean addUser(User user) {
        List<User> userList = usersRepo.findAll();
        for (User u : userList){
            if(u.getUsername().equals(user.getUsername())) return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        usersRepo.save(user);
        return true;
    }

    public User getUserByUserName(String username) {
        return usersRepo.getUserByUsername(username);
    }

    public void saveUser(User user){
        usersRepo.save(user);
    }
}
