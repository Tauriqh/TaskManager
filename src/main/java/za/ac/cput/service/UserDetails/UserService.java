package za.ac.cput.service.UserDetails;

import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.service.IService;

import java.util.Set;

public interface UserService extends IService<User, String> {
    Set<User> getAll();
}
