package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/")
    public String home(@RequestParam(value = "firstName" ,required = false) String firstName,
                       @RequestParam(value = "age" ,required = false) Integer age,
                       Model model) {

        model.addAttribute("name","Hello "+ firstName+ " age "+age);
        return "Home_page";
    }
    @GetMapping("/next")
    public String next(Model model) {
        return "new_page";
    }

}
