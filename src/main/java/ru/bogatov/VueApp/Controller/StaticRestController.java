package ru.bogatov.VueApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bogatov.VueApp.Entities.Data;
import ru.bogatov.VueApp.Services.StaticService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("api/stat")
public class StaticRestController {

    StaticService staticService;

    public StaticRestController(StaticService staticService) {
        this.staticService = staticService;
    }
    @GetMapping("/products")
    public Data getProductData(){
        return staticService.getDataProducts();
    }

    @GetMapping("/brands")
    public Data getBrandData(){
        return staticService.getDataBrands();
    }

    @GetMapping("/money/{from}:{to}")
    public Data getMoney(@PathVariable String from, @PathVariable String to) throws ParseException {
        Date dFrom = new SimpleDateFormat("yyyy-MM-dd").parse(from);
        Date dTo = new SimpleDateFormat("yyyy-MM-dd").parse(to);
        return staticService.getDataMoney(dFrom,dTo);
    }
}
