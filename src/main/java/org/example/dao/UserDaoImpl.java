package org.example.dao;



import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory emf;

//    @Autowired
//    public UserDaoImpl(EntityManagerFactory emf){
//        this.emf = emf;
//    }

    @Override
    public void addUser(User user) {
        EntityTransaction currentTransaction = null;
        EntityManager em = emf.createEntityManager();
        try {
            currentTransaction = em.getTransaction();
            currentTransaction.begin();
            em.persist(user);
            currentTransaction.commit();
        } catch (Exception e) {
            if (currentTransaction != null) {
                currentTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateUser(User user) {
        EntityTransaction currentTransaction = null;
        EntityManager em = emf.createEntityManager();
        try {
            currentTransaction = em.getTransaction();
            currentTransaction.begin();
            em.merge(user);
            currentTransaction.commit();
        } catch (Exception e) {
            if (currentTransaction != null) {
                currentTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        EntityTransaction currentTransaction = null;
        EntityManager em = emf.createEntityManager();
        try {
            currentTransaction = em.getTransaction();
            currentTransaction.begin();
            em.remove(user);
            currentTransaction.commit();
        } catch (Exception e) {
            if (currentTransaction != null) {
                currentTransaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public User findUserById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<User> findAllUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<User> users = em.createQuery("from User ").getResultList();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

}
