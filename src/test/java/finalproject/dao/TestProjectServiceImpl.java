package goit.group8.finalproject.dao;

import goit.group8.finalproject.model.Project;
import goit.group8.finalproject.model.ProjectStatus;
import goit.group8.finalproject.service.ProjectServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

public class TestProjectServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(TestProjectServiceImpl.class);

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("forTest.appconfig-root.xml");
    private ProjectServiceImpl service = (ProjectServiceImpl) applicationContext.getBean("ProjectServiceImpl");

    @Test
    public void testService(){
        String[] testSaveExpected = {"nameforTestSave", "manufacturerForTestSave", "descriptionForTest"};
        Integer recordCount = service.showProjects().size();

        Project projectSave = new Project();
        projectSave.setName(testSaveExpected[0]);
        projectSave.setCost(10.0);

        service.addProject(projectSave);

        List<Project> projects = service.showProjects();
        Project projectLoad = projects.get(projects.size()-1);

        String[] testSaveActual = {projectLoad.getName()};

        Assert.assertArrayEquals("compare text field", testSaveExpected, testSaveActual );
        Assert.assertEquals("compate cost", projectSave.getCost(), projectLoad.getCost());

        service.removeProject(projectLoad.getId());

        Integer recordCountForTest = service.showProjects().size();

        Assert.assertEquals("compare count elements", recordCount, recordCountForTest);
    }
}
