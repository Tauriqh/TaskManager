package za.ac.cput.repository.UserDetails.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.repository.UserDetails.EmailRepository;

import java.util.*;

@Repository("emailRepository")
public class EmailRepositoryImpl implements EmailRepository {

    private static EmailRepositoryImpl repository = null;
    private Map<String, Email> emails;

    private EmailRepositoryImpl() {
        this.emails = new HashMap<>();
    }

    public static EmailRepository getRepository(){
        if(repository == null) repository = new EmailRepositoryImpl();
        return repository;
    }

    public Email create(Email email){
        this.emails.put(email.getEmailAddressd(),email);
        return email;
    }

    public Email read(String emailAddress){
        return this.emails.get(emailAddress);
    }

    public Email update(Email email) {
        this.emails.replace(email.getEmailAddressd(),email);
        return this.emails.get(email.getEmailAddressd());
    }

    public void delete(String emailAddress) {
        this.emails.remove(emailAddress);
    }

    public Set<Email> getAll(){
        Collection<Email> emails = this.emails.values();
        Set<Email> set = new HashSet<>();
        set.addAll(emails);
        return set;
    }

}