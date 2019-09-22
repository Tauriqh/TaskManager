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

    @PostMapping("/create/{firstName},{lastName}")
    //@RequestMapping(value="/create/{firstName}/{lastName}", method=RequestMethod.POST)
    @ResponseBody
    public User create(@PathVariable String firstName, @PathVariable String lastName) {
        User user = UserFactory.buildUser(firstName, lastName);
        return service.create(user);
        //return firstName + lastName;
    }

    /* @PostMapping("/create/**")
    @ResponseBody
    public HttpServletRequest create(@PathVariable HttpServletRequest request) {
        String ii = Ser
        User user = UserFactory.buildUser(firstName, lastName);
    //return service.create(user);
        return request;
    }*/

    /*@PostMapping("/create")
    @ResponseBody
    public User create(@RequestBody User user){
        return this.service.create(user);
    }*/

    @PutMapping("/update")
    @ResponseBody
    public User update(@RequestBody User user) {
        return this.service.update(user);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        this.service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public User read(@PathVariable String id) {
        return this.service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<User> getAll() {
        return this.service.getAll();
    }
}
