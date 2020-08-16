package ru.bogatov.VueApp.Controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.Message;
import ru.bogatov.VueApp.Services.MessageService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("message")
public class Messagecontroller {

    @Qualifier("getGsonBuilder")
    @Autowired
    public Gson jsonBuilder;
    @Autowired
    public MessageService messageService;


    @GetMapping("{id}")
    public String getMessage(@PathVariable String id){
        return jsonBuilder.toJson(messageService.getOneMessage(id));
    }

    @GetMapping("")
    public String getMessages() {
        return jsonBuilder.toJson(messageService.getAllMessages());
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
