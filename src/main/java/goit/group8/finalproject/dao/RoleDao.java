package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    Role findByType(String type);

    Role findById(int id);
}
