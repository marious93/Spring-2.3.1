package org.example.dao;


import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDao {

    private EntityManagerFactory factory;

    @Autowired
    public UserDao(EntityManagerFactory factory) {
        this.factory = factory;
    }


    public List<User> index() {
        List<User> users = null;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery("from User", User.class);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return users;
    }

    public User show(int id) {
        User user = null;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<User> query = em.createQuery("from User  where id=:id", User.class).
                    setParameter("id", id);
            user = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return user;
    }

    public void save(User user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(int id, User updatedUser) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("update User set name =:firstName, mail=:email, age=:age  where id=:id").
                    setParameter("firstName", updatedUser.getName()).setParameter("email", updatedUser.getMail()).
                    setParameter("age", updatedUser.getAge()).
                    setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void delete(int id) {

        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete from User where id=:id").setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}