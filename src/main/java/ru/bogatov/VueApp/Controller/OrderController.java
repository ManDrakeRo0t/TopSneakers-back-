package ru.bogatov.VueApp.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bogatov.VueApp.Entities.OrderForm;
import ru.bogatov.VueApp.Entities.Selling;
import ru.bogatov.VueApp.Services.OrderService;
import ru.bogatov.VueApp.Services.PunctService;
import ru.bogatov.VueApp.Services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/order")
@PreAuthorize("hasAuthority('USER')")
public class OrderController {

    PunctService punctService;
    UserService userService;
    OrderService orderService;

    public OrderController(PunctService punctService, UserService userService, OrderService orderService) {
        this.punctService = punctService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String getSingleOrderPage(@PathVariable Integer id,Model model){
        model.addAttribute("order",orderService.findById(id));
        return "orderSinglePage";
    }

    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Integer id, OrderForm form){
        orderService.editOrder(id,form);
        return "redirect:http://localhost:8082/administration";
    }

    @PostMapping("/pay/{id}")
    public String payOrder(@PathVariable Integer id){
        orderService.pay(id);
        return "redirect:http://localhost:8082/personal";
    }

    @GetMapping()
    public String GetOrderPage(Model model, Principal principal){
        int count = 0;
        if(userService.getUserByUserName(principal.getName()).getBusketList() != null){
            count = userService.getUserByUserName(principal.getName()).getBusketList().getProducts().size();
        }
        model.addAttribute("count",count);
        model.addAttribute("puncts",punctService.getPuncts());
        return "order";
    }

    @PostMapping()
    public String confirmOrder(Model model, Selling selling,Principal principal){
        if(orderService.confirmOrder(selling,principal)){
            model.addAttribute("msg","заказ оформлен! Вы можете ознакомиться с деталями в личном кабинете");
        }else {
            model.addAttribute("msg","Заказ не был оформлен! Попробуйте еще раз");
        }
        return "order";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id){
        orderService.delete(id);
        return "redirect:http://localhost:8082/personal";
    }

}
