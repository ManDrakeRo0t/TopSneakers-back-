package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.DeliverPunctRepo;
import ru.bogatov.VueApp.Entities.City;
import ru.bogatov.VueApp.Entities.DeliverPunct;

import java.util.List;

@Service
public class PunctService {

    DeliverPunctRepo deliverPunctRepo;
    CityService cityService;

    public PunctService(DeliverPunctRepo deliverPunctRepo, CityService cityService) {
        this.deliverPunctRepo = deliverPunctRepo;
        this.cityService = cityService;
    }

    public void addPunct(DeliverPunct deliverPunct){
        City city = cityService.getCityByName(deliverPunct.getCityName());
        deliverPunct.setCity(city);
        deliverPunctRepo.save(deliverPunct);
    }

    public List<DeliverPunct> getPuncts(){
        return deliverPunctRepo.findAll();
    }

    public DeliverPunct getPunct(String address) {
        return deliverPunctRepo.getDeliverPunctByAddress(address);
    }
}
