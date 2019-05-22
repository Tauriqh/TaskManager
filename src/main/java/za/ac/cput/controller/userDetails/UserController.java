package za.ac.cput.controller.userDetails;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.Factory.UserDetails.UserFactory;
import za.ac.cput.service.UserDetails.UserService;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService service;

    @PostMapping("/create/{userId,firstName,lastName}")
    @ResponseBody
    public User create(@PathVariable String userId, String firstName, String lastName) {
        User user = UserFactory.buildUser(userId, firstName, lastName);
        return service.create(user);
    }

    @PostMapping("/update")
    @ResponseBody
    public User update(User user) {
        return service.update(user);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public User read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<User> getAll() {
        return service.getAll();
    }
}
