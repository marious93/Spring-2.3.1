package org.example;


import org.example.config.JavaConfig;
import org.example.entity.User;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(JavaConfig.class);

//        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
//        List<User> list = userService.findAllUsers();
//        for (User user : list) {
//            System.out.println(user);
//        }

    }
}
