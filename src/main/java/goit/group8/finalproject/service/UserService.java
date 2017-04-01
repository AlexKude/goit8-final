package goit.group8.finalproject.service;

import goit.group8.finalproject.model.User;

import java.util.List;

public interface UserService {

    void addUser(User u);
    void updateUser(User u);
    void removeUser(int id);
    User getUserById(int id);
    User findByUsername(String login);
    List<User> showUsers();
}
