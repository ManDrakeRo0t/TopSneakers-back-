package ru.bogatov.VueApp.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.Message;
import ru.bogatov.VueApp.Services.MessageService;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    public MessageService messageService;


    @GetMapping("{id}")
    public Message getMessage(@PathVariable String id){

        return messageService.getOneMessage(id);
    }
    @GetMapping("")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public void addMessage(@RequestBody String text){
        messageService.saveMessage(text);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable String id){
        messageService.deleteMessage(id);
    }

    @PutMapping("{id}")
    public void editMessage(@PathVariable String id,@RequestBody String text){
        messageService.editMessage(id,text);
    }


}
