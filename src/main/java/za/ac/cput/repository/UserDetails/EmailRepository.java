package za.ac.cput.repository.UserDetails;

import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.repository.IRepository;

import java.util.Set;


public interface EmailRepository extends IRepository<Email, String> {
    Set<Email> getAll();
}
