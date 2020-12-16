package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.City;
@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

    City getCityByName(String name);

}
