package ru.bogatov.VueApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.City;
import ru.bogatov.VueApp.Entities.DeliverPunct;
import ru.bogatov.VueApp.Services.CityService;
import ru.bogatov.VueApp.Services.PunctService;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    CityService cityService;
    PunctService punctService;

    public CityRestController(CityService cityService, PunctService punctService) {
        this.cityService = cityService;
        this.punctService = punctService;
    }
    @GetMapping("/puncts")
    public List<DeliverPunct> getAllPuncts(){
        List<DeliverPunct> list = punctService.getPuncts();
        list.forEach(DeliverPunct::perform);
        return list;
    }

    @GetMapping("")
    public List<City> getAll(){
        return cityService.getAll();
    }

    @PostMapping("")
    public void addCity(@RequestBody String name){
        cityService.addCity(name);
    }

}
