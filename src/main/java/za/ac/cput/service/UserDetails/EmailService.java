package za.ac.cput.service.UserDetails;

import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.service.IService;

import java.util.Set;

public interface EmailService extends IService<Email, String> {
    Set<Email> getAll();
}
