package goit.group8.finalproject.service;

import goit.group8.finalproject.dao.ApplicationDao;
import goit.group8.finalproject.model.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    ApplicationDao appDao;

    @Override
    @Transactional("businessData")
    public void addApp(Application a) {
        a.setApplydate(new Date());
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

    public void setAppDao(ApplicationDao appDao) {
        this.appDao = appDao;
    }
}
