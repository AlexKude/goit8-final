package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaDao extends JpaRepository<User, Long> {
    User findByUsername(String login);

   }
