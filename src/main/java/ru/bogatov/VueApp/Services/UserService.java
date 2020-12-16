package ru.bogatov.VueApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.BusketEntryRepo;
import ru.bogatov.VueApp.Dao.BusketRepo;
import ru.bogatov.VueApp.Dao.UsersRepo;
import ru.bogatov.VueApp.Entities.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private UsersRepo usersRepo;

    @Autowired
    ProductService productService;
    @Autowired
    BusketEntryRepo busketEntryRepo;
    @Autowired
    BusketRepo busketRepo;

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



    public void addToBasket(Integer id, String username,Integer count) {
        User user = getUserByUserName(username);
        Product product = productService.getById(id);
        if(user.getBusketList()== null){ //creating basket if null
            Busket busket = new Busket();
            busket.setUser(user);
            busket.setProducts(new HashSet<>());
            Busket fromDb = busketRepo.save(busket);
            user.setBusketList(fromDb);
            usersRepo.save(user);
        }
        for(BusketEntry entry : user.getBusketList().getProducts()){//увеличиваем
            if(entry.getProduct().getId().equals(product.getId())){
                if(product.getCount().equals(entry.getCount())) return;
                if(product.getCount() >= entry.getCount() + count){
                    entry.setCount(entry.getCount() + count);
                    busketEntryRepo.save(entry);
                    return;
                }
            }
        }
        if(product.getCount() >= count){ //или создаем если не нашли
            BusketEntry busketEntry = new BusketEntry();
            busketEntry.setCount(count);
            busketEntry.setProduct(product);
            BusketEntry fromDb  = busketEntryRepo.save(busketEntry);
            user.getBusketList().getProducts().add(fromDb);
            busketRepo.save(user.getBusketList());
            usersRepo.save(user);
        }



    }

    public void editBasket(Integer id, String username,Integer count){
        User user = getUserByUserName(username);
        Product product = productService.getById(id);
        for(BusketEntry entry : user.getBusketList().getProducts()){
            if(entry.getProduct().getId().equals(product.getId())){
                if(product.getCount() >= count){
                    entry.setCount(count);
                    busketEntryRepo.save(entry);
                    return;
                }
                if(product.getCount().equals(entry.getCount())) return;
            }
        }
    }

    public void deleteBasket(String username, int id) {
        User user = getUserByUserName(username);
        for(BusketEntry busketEntry : user.getBusketList().getProducts()){
            if(busketEntry.getProduct().getId().equals(id)){
                user.getBusketList().getProducts().remove(busketEntry);
                busketEntryRepo.delete(busketEntry);
                usersRepo.save(user);
                return;
            }
        }
    }
}
