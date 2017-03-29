package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

SessionFactory sessionFactory;

    public Role findById(int id) {
        return getById(id);
    }

    public Role findByType(String type) {
        Session session = sessionFactory.getCurrentSession();
        Role r = (Role) session.load(Role.class, new Integer(type));
        return r;
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Role> roleList = session.createQuery("select r from " + Role.class.getName() + " r").list();
        return roleList;
    }

}
