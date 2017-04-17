package goit.group8.finalproject.controller;

import goit.group8.finalproject.model.Role;
import goit.group8.finalproject.model.User;
import goit.group8.finalproject.service.SecurityService;
import goit.group8.finalproject.service.UserService;
import goit.group8.finalproject.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        List<Role> roles = new ArrayList<Role>();
        roles = userService.getAllowedRoles();
        model.addAttribute("rolesList", roles);

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "registration";
        }

        userService.addUser(userForm);


        securityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null){
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null){
            model.addAttribute("message", "Logged out successfully.");
        }

        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null){
            model.addAttribute("message", "Logged out successfully.");
        }
        return "admin";
    }

    /* private String getPrincipal(){
         String userName = null;
         Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

         if (principal instanceof UserDetails) {
             userName = ((UserDetails)principal).getUsername();
         } else {
             userName = principal.toString();
         }
         return userName;
     }*/
    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.showAllUsers());
        return "users";
    }

    @RequestMapping(value = "/freelancers", method = RequestMethod.GET)
    public String listFreelancers(Model model){
        model.addAttribute("freelancer", new User());
        model.addAttribute("listFreelancers", this.userService.showUsersByRoleId(1));
        return "freelancers";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getId() == 0) {
            this.userService.addUser(user);
        }
        else {
            this.userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping("/remove_user/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("/edit_user/{id}")
    public String editUser(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.showAllUsers());
        model.addAttribute("allRolesList", userService.getAllRoles());
        return "users";
    }

    @RequestMapping("/userdata/{id}") //to view users details on separate page
    public String userData(@PathVariable("id") int id, Model model){ // we pass id and create model
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";//return userData page
    }

    @InitBinder({"user","userForm","role","roles"})
    protected void initBinder(WebDataBinder binder) {
        /*binder.registerCustomEditor(Set.class, "roles", new CustomCollectionEditor(Set.class)
        {
            @Override
            protected Object convertElement(Object element)
            {
                Long id = null;

                if(element instanceof String && !((String)element).equals("")){
                    //From the JSP 'element' will be a String
                    try{
                        id = Long.parseLong((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Long) {
                    //From the database 'element' will be a Long
                    id = (Long) element;
                }

                return id != null ? userService.loadRoleById(id) : null;
            }
        });*/

        binder.registerCustomEditor(Set.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                String[] ids = text.split(",");
                Set<Role> roles = new HashSet<Role>();
                for(String str : ids) {
                    Role r = new Role();
                    r.setId(Long.parseLong(str));
                    roles.add(r);
                }
                setValue(roles);
            }

           /*@Override
            public String getAsText() {
                Object value = getValue();
                return (value != null ? value.toString() : "");
            }*/
        });
    }
}
