package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User u) {
        Session session = sessionFactory.getCurrentSession();
        session.save(u);
        logger.info("User is added successfully. User details: " + u);
    }

    @Override
    public void updateUser(User u) {
        Session session = sessionFactory.getCurrentSession();
        session.update(u);
        logger.info("User is updated successfully. User details: " + u);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));//load by id
        if (u != null) {
            session.delete(u);
        }
        logger.info("User have been removed successfully. User details: " + u);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));//load by id
        logger.info("User has been loaded successfully. User details: " + u);
        return u;

    }

    @Override
    public User findByUsername(String login) {
        Session session = sessionFactory.getCurrentSession();
        //User u = (User) session.load(User.class, new String(login));//load by login
        List<User> userList = session.createQuery("select u from " + User.class.getName() + " u where u.login = '" + login +"'").list();
        User u = userList.isEmpty() ? null : userList.get(0);
        logger.info("User has been loaded successfully. User details: " + u);
        return u;
    }

    @Override
    public List<User> showUsersByRoleId(int rId) {
        Session session = sessionFactory.getCurrentSession();
        List<User> userListByRoleId = session.createSQLQuery("SELECT * FROM users u, user_roles ur WHERE ur.user_id = u.id AND ur.role_id = " + rId).list();

        /*for (User u : userListByRoleId){
            logger.info("loaded user (role: " + rId + ") details:" + u);
        }*/

        return userListByRoleId;
    }

    @Override
    public List<User> showAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("select u from " + User.class.getName() + " u").list();
        for (User u : userList) {
            logger.info("loaded user details: " + u);
        }
        return userList;
    }
}
