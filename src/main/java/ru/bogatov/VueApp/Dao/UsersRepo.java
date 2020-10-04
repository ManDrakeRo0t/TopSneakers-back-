package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bogatov.VueApp.Entities.Message;
import ru.bogatov.VueApp.Entities.User;

import java.util.List;

public interface UsersRepo extends JpaRepository<User,Long> {

}
