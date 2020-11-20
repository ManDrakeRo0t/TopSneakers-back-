package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.AttributesValues;
@Repository
public interface AttributeValuesRepo extends JpaRepository<AttributesValues,Integer> {
}
