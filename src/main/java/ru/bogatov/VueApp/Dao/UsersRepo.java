package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Message;
import ru.bogatov.VueApp.Entities.User;

import java.util.List;
@Repository
public interface UsersRepo extends JpaRepository<User,Long> {

}
