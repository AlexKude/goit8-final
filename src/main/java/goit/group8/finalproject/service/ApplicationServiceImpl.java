package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.ApplicationDao;
import goit.group8.finalproject.dao.ProjectDao;
import goit.group8.finalproject.dao.UserDao;
import goit.group8.finalproject.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationDao appDao;

    @Autowired
    ProjectDao projectDao;

    @Autowired
    UserDao userDao;

    @Autowired
    SecurityService securityService;

    @Override
    @Transactional("businessData")
    public void addApp(Application a) {
        a.setApplydate(new Date());
        a.setFreelancer(userDao.getUserById(securityService.getCurrentUserId()));

       /* a.setProject(projectDao.getProjectbyId(projId));*/ /*Need to do!!!*/

        appDao.addApp(a);
    }

    @Override
    @Transactional("businessData")
    public void updateApp(Application a) {
        appDao.updateApp(a);
    }

    @Override
    @Transactional("businessData")
    public void removeApp(int id) {
        appDao.removeApp(id);
    }

    @Override
    @Transactional("businessData")
    public Application getAppById(int id) {
        return appDao.getAppById(id);
    }

    @Override
    @Transactional("businessData")
    public List<Application> showAllApps() {
        return appDao.showAllApps();
    }

    @Override
    @Transactional("businessData")
    public List<Application> showAppsByFreelancer() {
        return appDao.showAppsByFreelancerId(securityService.getCurrentUserId());
    }

    @Override
    @Transactional("businessData")
    public List<Application> showAppsByCustomer() {
        return appDao.showAppsByCustomerId(securityService.getCurrentUserId());
    }

    @Override
    public List<Application> showAppsByProjectId(int id) {
        return appDao.showAppsByProjectId(id);
    }


    public void setAppDao(ApplicationDao appDao) {
        this.appDao = appDao;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
