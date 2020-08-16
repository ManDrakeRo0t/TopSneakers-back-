package ru.bogatov.VueApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.MessagesRepo;
import ru.bogatov.VueApp.Entities.Message;
import ru.bogatov.VueApp.Exeptions.NotFoundExeption;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessagesRepo messagesRepo;

    public void saveMessage(String text){
        Message message = new Message();
        message.setText(text);
        messagesRepo.save(message);
    }

    public void editMessage(String id,String text){
        Message message = messagesRepo.getMessageById(Integer.parseInt(id));
        message.setText(text);
        messagesRepo.save(message);
    }

    private Message findMessageById(String id){
        Message message = messagesRepo.getMessageById(Integer.parseInt(id));
        if(message == null) throw new NotFoundExeption();
        return message;
    }

    public Message getOneMessage(String id){
        return findMessageById(id);
    }

    public void deleteMessage(String id){
        messagesRepo.delete(findMessageById(id));
    }

    public List<Message> getAllMessages(){
        return messagesRepo.findAll();
    }


}
