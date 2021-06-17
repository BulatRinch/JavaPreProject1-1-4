package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jm.task.core.jdbc.util.Util;



public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        transaction.commit();
        session.close();

    }

    @Override
    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS user";
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery(query).executeUpdate();
        transaction.commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = new User(name,lastName,age);
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = (User) session.get(User.class,id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);

        List<User> userList = criteria.list();

        transaction.commit();
        session.close();





        return userList;
    }

    @Override
    public void cleanUsersTable() {
        String query = "DELETE FROM user";
        Transaction transaction = null;
        Session session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.createSQLQuery(query).executeUpdate();
        transaction.commit();
        session.close();

    }
}
