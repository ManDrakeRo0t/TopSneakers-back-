package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.BusketEntry;

@Repository
public interface BusketEntryRepo extends JpaRepository<BusketEntry,Integer> {
}
