package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bogatov.VueApp.Entities.PicturesEntry;

public interface PicturesEntryRepo extends JpaRepository<PicturesEntry,Integer> {
}
