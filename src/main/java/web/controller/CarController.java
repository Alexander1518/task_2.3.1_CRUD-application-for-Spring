package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

@Controller
public class CarController {
    private final CarServiceImpl carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(defaultValue = "0") int count, Model model) {
        if (count != 0) {
            model.addAttribute("cars", carService.getCar(count));
        } else {
            model.addAttribute("cars", carService.fiveCars());
        }
        return "cars";
    }
}