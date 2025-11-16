package org.example.controller;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDao.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@RequestParam int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @RequestParam int id) {
        model.addAttribute("user", userDao.show(id));
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam int id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userDao.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String delete(@RequestParam int id) {
        userDao.delete(id);
        return "redirect:/users";
    }


}
