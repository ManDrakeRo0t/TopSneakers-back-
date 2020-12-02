package ru.bogatov.VueApp.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.AttributeRepo;
import ru.bogatov.VueApp.Dao.AttributeValuesRepo;
import ru.bogatov.VueApp.Entities.Attribute;
import ru.bogatov.VueApp.Entities.AttributesValues;
import ru.bogatov.VueApp.Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AttributeService {
    AttributeRepo attributeRepo;
    AttributeValuesRepo attributeValuesRepo;
    ProductService productService;


    public AttributeService(AttributeRepo attributeRepo, AttributeValuesRepo attributeValuesRepo, ProductService productService) {
        this.attributeRepo = attributeRepo;
        this.attributeValuesRepo = attributeValuesRepo;
        this.productService = productService;
    }

    public List<AttributesValues> getAttributes(Integer id){
        return productService.getById(id).getAttributesValues();
    }

    public void editAttributes(Integer id, String s) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String,String>> attributes = mapper.readValue(s,List.class);
        Product product = productService.getById(id);
        List<AttributesValues> valuesList = new ArrayList<>();
        for(Map<String,String> map : attributes){
            String name = map.get("name");
            String value = map.get("value");
            if(name.equals("")) continue;
            Attribute attribute = attributeRepo.findAttributeByName(name);
            if(attribute == null){
                Attribute atr = new Attribute();
                atr.setName(name);
                attribute = attributeRepo.save(atr);
            }
            AttributesValues attributesValues = new AttributesValues();
            attributesValues.setAttribute(attribute);
            attributesValues.setStringValue(value);
            valuesList.add(attributeValuesRepo.save(attributesValues));
        }
        product.setAttributesValues(valuesList);
        productService.saveProduct(product);
    }
}
