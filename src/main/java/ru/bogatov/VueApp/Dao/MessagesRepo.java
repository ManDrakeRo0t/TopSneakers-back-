package ru.bogatov.VueApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogatov.VueApp.Entities.Message;

import java.util.List;

@Repository
public interface MessagesRepo extends JpaRepository<Message,Long> {
    public Message getMessageById(Integer id);
}
