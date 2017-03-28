package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById (int id);

    User findByUserName(String login);

    List<User> showUsers();
}
