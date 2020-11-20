package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Busket;
@Repository
public interface BusketRepo extends JpaRepository<Busket,Integer> {
}
