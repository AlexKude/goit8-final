package goit.group8.finalproject.service;

import goit.group8.finalproject.model.Application;

import java.util.List;

public interface ApplicationService {
    void addApp(Application a, int projId);
    void updateApp(Application a, int projId);
    void removeApp(int id);
    Application getAppById(int id);
    List<Application> showAllApps();
}
