package dao;

import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserDao {

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

}
