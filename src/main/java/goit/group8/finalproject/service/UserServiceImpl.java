package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.UserDao;
import goit.group8.finalproject.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Override
    @Transactional("businessData")
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    @Transactional("businessData")
    public void updateUser(User u) {
        userDao.updateUser(u);
    }

    @Override
    @Transactional("businessData")
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional("businessData")
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User findByUserName(String login) {
        return userDao.findByUserName(login);
    }

    @Override
    @Transactional("businessData")
    public List<User> showUsers() {
        return userDao.showUsers();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
