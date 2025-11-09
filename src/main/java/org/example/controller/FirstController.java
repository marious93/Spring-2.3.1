package org.example.controller;

import org.example.config.JavaConfig;
import org.example.entity.User;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FirstController {

    @GetMapping("/")
    public String hi(Model model) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceImpl.class);
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

}
