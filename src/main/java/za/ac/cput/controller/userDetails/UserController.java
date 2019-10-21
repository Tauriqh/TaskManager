package za.ac.cput.controller.userDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.WebValidator;
import za.ac.cput.domain.userDetails.User;
import za.ac.cput.exception.RecordNotFoundException;
import za.ac.cput.service.userDetails.impl.UserServiceImpl;

import javax.swing.*;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @RequestMapping
    public String getAllUsers(Model model){
        List<User> list = service.getAllUsers();

        model.addAttribute("users", list);
        return "userView";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException{
        if (id.isPresent()) {
            User entity = service.getUserById(id.get());
            model.addAttribute("user", entity);
        } else {
            model.addAttribute("user", new User());
        }
        return "editUserView";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteUserById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteUserById(id);
        return "redirect:/user";
    }

    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createOrUpdateUser(User user)
    {
        service.createOrUpdateUser(user);
        return "redirect:/user";
    }
}
