package za.ac.cput.service.UserDetails.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.repository.UserDetails.UserRepository;
import za.ac.cput.service.UserDetails.UserService;

import java.util.Set;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")

    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.create(user);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public User read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<User> getAll() {
        return repository.getAll();
    }
}