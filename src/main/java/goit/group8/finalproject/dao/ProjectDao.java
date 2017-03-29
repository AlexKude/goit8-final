package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Project;
import java.util.List;

public interface ProjectDao {
    void addProject(Project g);
    void updateProject(Project g);
    void removeProject(int id);
    Project getProjectById(int id);
    List<Project> showProjects();
}


