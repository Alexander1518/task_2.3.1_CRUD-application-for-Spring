package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        String messages = "Welcome dear customers!!!";
        model.addAttribute("messages", messages);
        return "hello";
    }
    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/create")
    public String createUserForm(User user) {
        return "create";
    }
    @PostMapping(value = "/create")
    public String createUser(User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update")
    public String changeUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}