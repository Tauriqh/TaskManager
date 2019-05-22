package za.ac.cput.service.UserDetails.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.repository.UserDetails.EmailRepository;
import za.ac.cput.service.UserDetails.EmailService;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("emailServiceImpl")
public class EmailServiceImpl implements EmailService {
    @Autowired
    @Qualifier("emailRepository")

    private EmailRepository repository;

    @Override
    public Email create(Email email) {
        return repository.create(email);
    }

    @Override
    public Email update(Email email) {
        return repository.update(email);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Email read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Email> getAll() {
        return repository.getAll();
    }
}