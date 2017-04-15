package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addApp(Application a) {
        Session session = sessionFactory.getCurrentSession();
        session.save(a);
        logger.info("Application are added successfully. App details: " + a);
    }

    @Override
    public void updateApp(Application a) {
        Session session = sessionFactory.getCurrentSession();
        session.update(a);
        logger.info("Project is updated successfully. Project details: " + a);
    }

    @Override
    public void removeApp(int id) {
       Session session = sessionFactory.getCurrentSession();
       Application a = (Application) session.load(Application.class, new Integer(id));

       if (a != null){
           session.delete(a);
       }
       logger.info("Project have been removed successfully. Project details: " + a);
    }

    @Override
    public Application getAppById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Application a = (Application) session.load(Application.class, new Integer(id));//load by id
        logger.info("Application has been loaded successfully. App details: "+ a);

        return a;
    }

    @Override
    public List<Application> showAllApps() {
        Session session = sessionFactory.getCurrentSession();
        List<Application> appList = session.createQuery("from Application").list();
        for (Application a : appList){
            logger.info("loaded project details: "+ a);
        }
        return appList;
    }

    @Override
    public List<Application> showAppsByFreelancerId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Application> appListByFreelancer = session.createQuery("select a from " +
                "Application a, User u where a.freelancer = u and u.id =" + id).list();
        return appListByFreelancer;
    }

    @Override
    public List<Application> showAppsByCustomerId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Application> appListByCustomer = session.createQuery("select p from " +
                "Project p, Application a, User u where a.project = p and p.customer = u and u.id = " + id).list();
        return appListByCustomer;
    }

    @Override
    public List<Application> showAppsByProjectId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Application> appListByProject = session.createQuery("select p from " +
                "Project p, Application a where a.project = p and p.id = " + id).list();
        return appListByProject;
    }
}
