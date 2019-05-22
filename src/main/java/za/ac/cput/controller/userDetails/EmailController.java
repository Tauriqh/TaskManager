package za.ac.cput.controller.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.Factory.UserDetails.EmailFactory;
import za.ac.cput.service.UserDetails.EmailService;

import java.util.Set;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    @Qualifier("emailServiceImpl")
    private EmailService service;

    @PostMapping("/create/{emailAddress,userId}")
    @ResponseBody
    public Email create(@PathVariable String emailAddress, String userId) {
        Email email = EmailFactory.buildEmail(emailAddress, userId);
        return service.create(email);
    }

    @PostMapping("/update")
    @ResponseBody
    public Email update(Email email) {
        return service.update(email);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Email read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Email> getAll() {
        return service.getAll();
    }
}
