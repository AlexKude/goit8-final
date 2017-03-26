package goit.group8.finalproject.service;


import goit.group8.finalproject.dao.ProjectDao;
import goit.group8.finalproject.model.Project;
import goit.group8.finalproject.model.ProjectStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class ProjectServiceImpl implements ProjectService{
    ProjectDao projectDao;

    @Override
    @Transactional("businessData")
    public void addProject(Project p) {
        p.setStartDate(new Date());
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
        return  projectDao.getProjectbyId(id);
    }

    @Override
    @Transactional("businessData")
    public List<Project> showProjects() {
        return projectDao.showProjects();
    }

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

}
