package by.gsu.pms.controllers;

import by.gsu.pms.beans.Role;
import by.gsu.pms.beans.User;
import by.gsu.pms.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/registration")
    public String registration(Map<String,Object> model){
        model.put("message","");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){
        User userFromDb = userRepo.getFirstByUsername(user.getUsername());
        if(userFromDb!=null){
            model.put("message","User with such a name is already registered!");
            return "/registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepo.save(user);
        model.put("message","");
        return "redirect:/login";
    }
}
