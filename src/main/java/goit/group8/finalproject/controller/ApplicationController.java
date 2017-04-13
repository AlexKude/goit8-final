package goit.group8.finalproject.controller;

import goit.group8.finalproject.model.Application;
import goit.group8.finalproject.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ApplicationController {

    ApplicationService appService;

    @Autowired(required=true)
    @Qualifier(value="appService")
    public void setAppService(ApplicationService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String listApps(Model model){
        model.addAttribute("application", new Application());
        model.addAttribute("listApps", this.appService.showAllApps());

        return "applications";
    }

    @RequestMapping(value = {"/application/add/{project_id}"}, method = RequestMethod.POST)
    public String addApp(@Valid Application app, @PathVariable("project_id") int projId){
        if (app.getId() == 0) { //so there is no this app in DB

            this.appService.addApp(app, projId);
        }
        else {
            this.appService.updateApp(app, projId);
        }

        return "redirect:/applications";
    }



    @RequestMapping("/remove_app/{id}")
    public String removeApp(@PathVariable("id") int id){
        this.appService.removeApp(id);
        return "redirect:/applications";
    }

    @RequestMapping("/edit_app/{id}")
    public String editApp(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("application", this.appService.getAppById(id));
        model.addAttribute("listApps", this.appService.showAllApps());
        return "applications";
    }

    @RequestMapping("/appdata/{id}") //to view applications details on separate page
    public String appData(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("application", this.appService.getAppById(id));
        return "appdata";//return appData page
    }
}
