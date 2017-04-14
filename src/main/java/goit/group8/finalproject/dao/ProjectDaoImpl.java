package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Project;
import goit.group8.finalproject.model.ProjectStatus;
import goit.group8.finalproject.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project p) {
        Session session = sessionFactory.getCurrentSession();
        if (p.getStatus() == null)
        {
            ProjectStatus status = (ProjectStatus) session.get(ProjectStatus.class, new Integer(1));
            if (status == null)
            {
                status = new ProjectStatus();
                status.setStatus_name("created");
                //status.setStatus_id(1);
                session.save(status);
            }
            p.setStatus(status);
        }
        session.save(p);
        logger.info("Goods are added successfully. Project details: "+ p);
    }

    @Override
    public void updateProject(Project p) {
        Session session = sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Project is updated successfully. Project details: "+ p);
    }

    @Override
    public void removeProject(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project p = (Project) session.load(Project.class, new Integer(id));//load by id
        if (p != null) {
            session.delete(p);
        }
        logger.info("Project have been removed successfully. Project details: "+ p);
    }

    @Override
    public Project getProjectbyId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project p = (Project) session.load(Project.class, new Integer(id));//load by id
        logger.info("Project has been loaded successfully. Project details: "+ p);
        return p;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> showProjects() {
        Session session = sessionFactory.getCurrentSession();
        List<Project> projectList = session.createQuery("from Project").list();
        for (Project p : projectList){
            logger.info("loaded project details: "+ p);
        }

        return projectList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> showProjectsByCustId(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Project> projectListByCustId = session.createQuery("from " + Project.class.getName() + " p, "
                + User.class.getName() + " u " +  "where u.id = p.user_id a and u.id = " + id ).list();

        return projectListByCustId;
    }
}
