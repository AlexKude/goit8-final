package goit.group8.finalproject.controller;

import goit.group8.finalproject.model.Application;
import goit.group8.finalproject.model.Project;
import goit.group8.finalproject.service.ApplicationService;
import goit.group8.finalproject.service.ProjectService;
import goit.group8.finalproject.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@Controller
/*@RequestMapping(value = "/projects")
@SessionAttributes(types = Project.class)*/
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ApplicationService appService;

    @Autowired(required = true)
    @Qualifier(value = "projectService")
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }


    @RequestMapping(value = "/projects", method = RequestMethod.GET)
//this will be first main page, so here we can add attributes to the model
    public String listProject(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("listProjects", this.projectService.showProjects());
        return "projects";
    }

   /* @RequestMapping(value = "/projectdata", method = RequestMethod.POST)
    public String selectProject(Project project) {

        Assert.notNull(project);
        Assert.notNull(project.getId());

        return "redirect:/applications";
    }*/

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project) {
        if (project.getId() == 0) { //so there is no this project in DB
            this.projectService.addProject(project);
        } else {
            this.projectService.updateProject(project);
        }

        return "redirect:/projects";
    }

    @RequestMapping("/remove/{id}")
    public String removeProject(@PathVariable("id") int id) {
        this.projectService.removeProject(id);
        return "redirect:/projects";
    }

    @RequestMapping("/edit/{id}")
    public String editProject(@PathVariable("id") int id, Model model) { // we pass id and create model
        model.addAttribute("project", this.projectService.getProjectbyId(id));
        model.addAttribute("listProjects", this.projectService.showProjects());
        return "projects";
    }

    @RequestMapping("/project/apply")
    public String applyProject(@RequestParam("id") int id, @RequestParam("proptext") String proptext , Model model) { // we pass id and create model
        Application app = new Application();
        app.setProject(this.projectService.getProjectbyId(id));
        app.setNote(proptext);
        appService.addApp(app);
        model.addAttribute("project", this.projectService.getProjectbyId(id));
        model.addAttribute("listProjects", this.projectService.showProjects());
        return "projects";
    }

    @RequestMapping("/projectdata/{id}") //to view projects details on separate page
    public String projectData(@PathVariable("id") int id, Model model) { // we pass id and create model
        model.addAttribute("project", this.projectService.getProjectbyId(id));
        return "projectdata";//return projectData page
    }

    @RequestMapping(value = "/customer_projects", method = RequestMethod.GET)
    public String listOfCustProjects(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("listOfCustProjects", this.projectService.showProjectsByCustId());

        return "customer_projects";
    }

}
