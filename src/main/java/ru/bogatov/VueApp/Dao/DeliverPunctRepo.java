package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.DeliverPunct;
@Repository
public interface DeliverPunctRepo extends JpaRepository<DeliverPunct,Integer> {
    DeliverPunct getDeliverPunctByAddress(String address);
}
