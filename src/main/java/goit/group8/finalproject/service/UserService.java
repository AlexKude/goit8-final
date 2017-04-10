package goit.group8.finalproject.service;

import goit.group8.finalproject.model.Role;
import goit.group8.finalproject.model.User;

import java.util.List;

public interface UserService {

    void addUser(User u);
    void updateUser(User u);
    void removeUser(int id);
    User getUserById(int id);
    User findByUsername(String login);
    List<User> showAllUsers();
    List<User> showUsersByRoleId(int rId);
    List<Role> getAllowedRoles();
    List<Role> getAllRoles();
    Role loadRoleById(long id);

}
