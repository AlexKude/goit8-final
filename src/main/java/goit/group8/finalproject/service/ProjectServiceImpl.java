package goit.group8.finalproject.service;


import goit.group8.finalproject.dao.ProjectDao;
import goit.group8.finalproject.dao.UserDao;
import goit.group8.finalproject.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional("businessData")
    public void addProject(Project p) {
        p.setStartDate(new Date());
        p.setCustomer(userDao.getUserById(securityService.getCurrentUserId()));
        projectDao.addProject(p);
    }


    @Override
    @Transactional("businessData")
    public void updateProject(Project p) {
        projectDao.updateProject(p);
    }

    @Override
    @Transactional("businessData")
    public void removeProject(int id) {
        projectDao.removeProject(id);
    }

    @Override
    @Transactional("businessData")
    public Project getProjectbyId(int id) {
        return projectDao.getProjectbyId(id);
    }

    @Override
    @Transactional("businessData")
    public List<Project> showProjects() {
        return projectDao.showProjects();
    }

    @Override
    @Transactional("businessData")
    public List<Project> showProjectsByCustId() {

        return projectDao.showProjectsByCustId(securityService.getCurrentUserId());
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

}
