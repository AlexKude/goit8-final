package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
