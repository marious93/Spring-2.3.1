package org.example;


//import org.example.config.JavaConfig;
import org.example.config.JavaConfig;
import org.example.config.WebConfig;
import org.example.entity.User;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
//        UserServiceImpl userService =  context.getBean(UserServiceImpl.class);
//        List<User> list = userService.findAllUsers();
//        for (User user : list) {
//            System.out.println(user);
//        }

    }
}
