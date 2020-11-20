package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.SellingEntry;
@Repository
public interface SellingEntryRepo extends JpaRepository<SellingEntry,Integer> {
}
