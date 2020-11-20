package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Attribute;
@Repository
public interface AttributeRepo extends JpaRepository<Attribute,Integer> {
}
