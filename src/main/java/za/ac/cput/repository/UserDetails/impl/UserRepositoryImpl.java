package za.ac.cput.repository.UserDetails.impl;

import org.springframework.stereotype.Repository;

import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.repository.UserDetails.UserRepository;

import java.util.*;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl repository = null;
    private Map<String, User> users;

    private UserRepositoryImpl() {
        this.users = new HashMap<>();
    }

    public static UserRepository getRepository(){
        if(repository == null) repository = new UserRepositoryImpl();
        return repository;
    }

    public User create(User user){
        this.users.put(user.getUserId(),user);
        return user;
    }

    public User read(String userId){
        return this.users.get(userId);
    }

    public User update(User user) {
        this.users.replace(user.getUserId(),user);
        return this.users.get(user.getUserId());
    }

    public void delete(String userId) {
        this.users.remove(userId);
    }

    public Set<User> getAll(){
        Collection<User> users = this.users.values();
        Set<User> set = new HashSet<>();
        set.addAll(users);
        return set;
    }
}