package goit.group8.finalproject.dao;

import com.sun.org.apache.xpath.internal.operations.String;
import goit.group8.finalproject.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StatusDaoImpl implements StatusDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Status> showAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Status> statusList = session.createQuery("from Status ").list();
        for (Status status : statusList) {
            logger.info("loaded project details: " + status);
        }
        return statusList;
    }

   /* @Override
    public Status findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Status status = (Status) session.load(Status.class, new String());
        logger.info("User has been loaded successfully. User details: " + status);
        return status;
    }*/

    @Override
    public Status findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = (Status) session.load(Status.class, new Integer(id));
        logger.info("User has been loaded successfully. User details: " + status);
        return status;
    }
}
