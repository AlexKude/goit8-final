package goit.group8.finalproject.service;

import goit.group8.finalproject.model.Project;

import java.util.List;

public interface ProjectService {

    void addProject(Project p);
    void updateProject(Project p);
    void removeProject(int id);
    Project getProjectbyId(int id);
    List<Project> showProjects();
}
