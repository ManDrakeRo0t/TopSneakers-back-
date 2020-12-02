package ru.bogatov.VueApp.Controller;

import org.springframework.web.bind.annotation.*;
import ru.bogatov.VueApp.Dao.BrandNameRepo;
import ru.bogatov.VueApp.Entities.BrandName;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandRestController {

    BrandNameRepo brandNameRepo;

    public BrandRestController(BrandNameRepo brandNameRepo) {
        this.brandNameRepo = brandNameRepo;
    }

    @GetMapping("")
    public List<BrandName>  getBrandNames(){
        return brandNameRepo.findAll();
    }

    @PostMapping("")
    public void addBrandName(@RequestBody String name){ //todo проверить уникальность
        BrandName brandName = new BrandName();
        brandName.setName(name);
        brandNameRepo.save(brandName);
    }
}
