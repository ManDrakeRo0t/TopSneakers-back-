package ru.bogatov.VueApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogatov.VueApp.Entities.DeliverPunct;
import ru.bogatov.VueApp.Services.PunctService;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationsController {
    PunctService punctService;

    public LocationsController(PunctService punctService) {
        this.punctService = punctService;
    }

    @GetMapping
    public String getLocations(Model model){
        List<DeliverPunct> list = punctService.getPuncts();
        list.forEach(DeliverPunct::perform);
        model.addAttribute("puncts",list);
        return "locations";
    }

}
