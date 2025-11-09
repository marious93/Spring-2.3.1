package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/")
    public String hi(Model model) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(BigConfig.class);
//        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
//        List<User> userList = userService.findAllUsers();
//        model.addAttribute("userList", userList);
        return "test";
    }

}
