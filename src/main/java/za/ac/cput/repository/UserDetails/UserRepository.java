package za.ac.cput.repository.UserDetails;

import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User, String> {
    Set<User> getAll();
}
