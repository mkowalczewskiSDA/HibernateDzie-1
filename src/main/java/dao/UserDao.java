package dao;

import model.Order;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UserDao {

    private Session session;

    void openSession() {session = HibernateUtil.getSessionFactory().openSession();}

    public User findById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.find(User.class, id);
        session.close();
        return user;
    }

    public void insertUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }

    public void deleteUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.flush();
        session.close();
    }

    public void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(session.find(User.class, user.getId()) != null) {
            session.merge(user);
        }
        session.flush();
        session.close();
    }

    public List<User> findByUser(User user){
        openSession();
        Query query = session.createQuery("Select u from User u join fetch u.orders o where u = :user").setParameter("user", user);
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

}
