package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.CityRepo;
import ru.bogatov.VueApp.Entities.City;

import java.util.List;

@Service
public class CityService {

    CityRepo cityRepo;

    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public City addCity(String name){
        City city = cityRepo.getCityByName(name);
        if(city == null){
            city = new City();
            city.setName(name);
            return cityRepo.save(city);
        }
        return city;
    }

    public City getCityByName(String name){
        return cityRepo.getCityByName(name);
    }

    public List<City> getAll(){
        return cityRepo.findAll();
    }

}
