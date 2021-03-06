package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.RoleDao;
import goit.group8.finalproject.dao.UserDao;
import goit.group8.finalproject.model.Role;
import goit.group8.finalproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional("businessData")
    public void addUser(User u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        //Set<Role> roles = new HashSet<>();
        //roles.add(roleDao.findOne(3L));
        //u.setRoles(roles);
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
    public List<User> showAllUsers() {

        return userDao.showAllUsers();
    }

    @Override
    @Transactional("businessData")
    public List<User> showUsersByRoleId(int rId) {

        return userDao.showUsersByRoleId(rId);
    }

    @Override
    public List<Role> getAllowedRoles() {
        List<Role> roles = new ArrayList<>();
        roles.addAll(roleDao.findAll());
        roles.removeIf(r -> r.getName().equals("ROLE_ADMIN"));

        return roles;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        roles.addAll(roleDao.findAll());

        return roles;
    }

    @Override
    public Role loadRoleById(long id) {
        return roleDao.findOne(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
