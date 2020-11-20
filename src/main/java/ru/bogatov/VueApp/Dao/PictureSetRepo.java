package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.PicturesSet;
@Repository
public interface PictureSetRepo extends JpaRepository<PicturesSet,Integer> {
}
