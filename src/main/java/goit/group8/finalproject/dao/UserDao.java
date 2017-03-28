package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository{

    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById (int id);

    User findByUserName(String login);

    List<User> showUsers();
}
