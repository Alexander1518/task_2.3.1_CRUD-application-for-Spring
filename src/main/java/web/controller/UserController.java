package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserServiceImpl;

@Controller
public class UserController {
    private final UserServiceImpl carService = new UserServiceImpl();
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        String messages = "Welcome dear customers!!!";
        model.addAttribute("messages", messages);
        return "hello";
    }

    @GetMapping(value = "/users")
    public String printCar(@RequestParam(defaultValue = "0") int count, Model model) {
        if (count != 0) {
            model.addAttribute("users", carService.getUser(count));
        } else {
            model.addAttribute("users", carService.fiveUser());
        }
        return "users";
    }
}