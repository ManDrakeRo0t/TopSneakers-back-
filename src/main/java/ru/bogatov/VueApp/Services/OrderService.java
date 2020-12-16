package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.SellingEntryRepo;
import ru.bogatov.VueApp.Dao.SellingRepo;
import ru.bogatov.VueApp.Entities.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@Service
public class OrderService {
    UserService userService;
    SellingEntryRepo sellingEntryRepo;
    SellingRepo sellingRepo;
    PunctService punctService;

    public Selling findById(Integer id){
        return sellingRepo.findById(id).orElse(null);
    }

    public OrderService(UserService userService, SellingEntryRepo sellingEntryRepo, SellingRepo sellingRepo, PunctService punctService) {
        this.userService = userService;
        this.sellingEntryRepo = sellingEntryRepo;
        this.sellingRepo = sellingRepo;
        this.punctService = punctService;
    }

    public boolean confirmOrder(Selling selling, Principal principal){
        User user = userService.getUserByUserName(principal.getName());
        Busket busket = user.getBusketList();
        if(busket == null) return false;
        if(busket.getProducts() == null || busket.getProducts().size() == 0) return false;
        selling.setUser(user);
        selling.setSellingEntrySet(new ArrayList<>());
        selling.setAccepted(false);
        selling.setDeleted(false);
        selling.setPayed(false);
        selling.setDetails("Рассматривается");
        String[] parts = selling.getAddress().split("-");
        selling.setDeliverPunct(punctService.getPunct(parts[1].trim()));
        Selling SfromDb =  sellingRepo.save(selling);
        for(BusketEntry busketEntry : busket.getProducts()){
            SellingEntry sellingEntry = new SellingEntry();
            sellingEntry.setCount(busketEntry.getCount());
            sellingEntry.setProduct(busketEntry.getProduct());
            sellingEntry.setSale(busketEntry.getProduct().getSale());
            sellingEntry.setPrice(busketEntry.getProduct().getPrice() * (1 - busketEntry.getProduct().getSale() / 100));
            sellingEntry.setSelling(SfromDb);
            SellingEntry fromDb = sellingEntryRepo.save(sellingEntry);
            selling.getSellingEntrySet().add(fromDb);
        }
        Selling NEW =  sellingRepo.save(SfromDb);
        if(user.getSellingList() == null) user.setSellingList(new ArrayList<>());
        user.getSellingList().add(NEW);
        userService.saveUser(user);
        return true;
    }

    public void delete(Integer id){
        Selling selling = sellingRepo.getOne(id);
        selling.setDeleted(true);
        sellingRepo.save(selling);
    }

    public void editOrder(Integer id, OrderForm form) {
        Selling selling = findById(id);
        if(form.status == null){
            selling.setAccepted(false);
        }else{
            selling.setAccepted(true);
        }
        selling.setDetails(form.details);
        sellingRepo.save(selling);
    }

    public void pay(Integer id) {
        Selling selling = findById(id);
        selling.setPayed(true);
        Date d = new Date();
        java.sql.Date date = new java.sql.Date(d.getTime());
        selling.setPayDate(date);
        sellingRepo.save(selling);
    }
}
