package goit.group8.finalproject.controller;

import goit.group8.finalproject.model.Project;
import goit.group8.finalproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
    ProjectService projectService;

    @Autowired(required=true)
    @Qualifier(value="projectService")
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)//this will be first main page, so here we can add attributes to the model
    public String listProject(Model model){
        model.addAttribute("project", new Project());
        model.addAttribute("listProjects", this.projectService.showProjects());
        return "projects";
    }

    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project){
        if (project.getId() == 0) { //so there is no this project in DB
            this.projectService.addProject(project);
        }
        else {
            this.projectService.updateProject(project);
        }

        return "redirect:/projects";//redirect to the main page
    }

    @RequestMapping("/remove/{id}")
    public String removeProject(@PathVariable("id") int id){
        this.projectService.removeProject(id);
        return "redirect:/projects";//redirect to the main page
    }

    @RequestMapping("/edit/{id}")
    public String editProject(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("project", this.projectService.getProjectbyId(id));
        model.addAttribute("listProjects", this.projectService.showProjects());
        return "projects";//return to the main page
    }

    @RequestMapping("/projectdata/{id}") //to view projects details on separate page
    public String projectData(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("project", this.projectService.getProjectbyId(id));
        return "projectdata";//return projectData page
    }
}
