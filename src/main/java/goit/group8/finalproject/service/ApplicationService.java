package goit.group8.finalproject.service;

import goit.group8.finalproject.model.Application;

import java.util.List;

public interface ApplicationService {

    void addApp(Application a);
    void updateApp(Application a);
    void removeApp(int id);
    Application getAppById(int id);
    List<Application> showAllApps();
    List<Application> showAppsByFreelancer();
    List<Application> showAppsByCustomer();
    List<Application> showAppsByProjectId(int id);
}
