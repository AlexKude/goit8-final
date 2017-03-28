package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
