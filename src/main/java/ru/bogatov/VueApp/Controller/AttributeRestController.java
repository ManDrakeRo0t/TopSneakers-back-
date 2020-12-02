package ru.bogatov.VueApp.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Entities.AttributesValues;
import ru.bogatov.VueApp.Services.AttributeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AttributeRestController {

    AttributeService attributeService;

    public AttributeRestController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @PostMapping("/attribute/{id}")
    public void addAttributes(@PathVariable Integer id, @RequestBody Map<String,String> attributes) throws JsonProcessingException {
        attributeService.editAttributes(id,attributes.get("attributes"));
    }
    @GetMapping("/attribute/{id}")
    public List<AttributesValues> loadAttributes(@PathVariable Integer id){
        return attributeService.getAttributes(id);
    }
}
