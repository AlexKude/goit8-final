package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Application;

import java.util.List;

public interface ApplicationDao {
    void addApp(Application a);
    void updateApp(Application a);
    void removeApp(int id);
    Application getAppById(int id);
    List<Application> showAllApps();
    List<Application> showAppsByFreelancerId(int id);
    List<Application> showAppsByCustomerId(int id);
}
