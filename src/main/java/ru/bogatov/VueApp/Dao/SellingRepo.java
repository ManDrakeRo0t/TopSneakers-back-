package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Selling;
@Repository
public interface SellingRepo extends JpaRepository<Selling,Integer> {
    public void deleteById(Integer id);
}
