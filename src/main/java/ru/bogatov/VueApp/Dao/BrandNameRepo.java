package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.BrandName;
@Repository
public interface BrandNameRepo extends JpaRepository<BrandName,Integer> {
    public BrandName getBrandNameByName(String name);
}
