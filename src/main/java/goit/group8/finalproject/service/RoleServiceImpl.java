package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.RoleDao;
import goit.group8.finalproject.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public Role findByType(String type) {
        return roleDao.findByType(type);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
