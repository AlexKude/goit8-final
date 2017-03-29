package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.RoleDao;
import goit.group8.finalproject.dao.UserDao;
import goit.group8.finalproject.model.Role;
import goit.group8.finalproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(goit.group8.finalproject.dao.UserDaoImpl userDao) {
    }
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional("businessData")
    public void addUser(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findById(3));
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
    @Transactional("businessData")
    public User findByUsername(String login) {
        return userDao.findByUsername(login);
    }

    @Override
    @Transactional("businessData")
    public List<User> showUsers() {
        return userDao.showUsers();
    }

}
