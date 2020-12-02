package ru.bogatov.VueApp.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String homePage(Model model){

        return "index";
    }
    @GetMapping("a")
    public String aPage(Model model){

        return "a";
    }
}
