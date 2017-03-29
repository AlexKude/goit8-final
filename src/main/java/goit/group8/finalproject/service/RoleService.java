package goit.group8.finalproject.service;

import goit.group8.finalproject.model.Role;

import java.util.List;

public interface RoleService {

    Role findById(int id);

    Role findByType(String type);

    List<Role> findAll();
}
