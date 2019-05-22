package za.ac.cput.repository.implementation.UserDetails;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.Factory.UserDetails.EmailFactory;
import za.ac.cput.repository.UserDetails.EmailRepository;
import za.ac.cput.repository.UserDetails.impl.EmailRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmailRepositoryImplTest {

    private EmailRepository repository;
    private Email email;

    private Email getSaved() {
        Set<Email> saved = this.repository.getAll();
        return saved.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmailRepositoryImpl.getRepository();
        this.email = EmailFactory.buildEmail("tauriq@gmail.com","1");
    }

    @Test
    public void create() {
        Email info = this.repository.create(this.email);
        d_getAll();
        Assert.assertEquals(info, this.email);
    }

    @Test
    public void read() {
        Email saved = getSaved();
        Email read = this.repository.read(saved.getEmailAddressd());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
        d_getAll();

    }

    @Test
    public void update() {
        String updateString = "henry@gmail.com";
        Email email = new Email.Builder().copy(getSaved()).emailAddress(updateString).build();
        System.out.println("In update, about_to_updated = " + email);
        Email updated = this.repository.update(email);
        System.out.println("In update, updated = " + updated);
        //Assert.assertSame(updateString, updated.getEmailAddressd());
        d_getAll();
    }

    @Test
    public void e_delete() {
        Email saved = getSaved();
        d_getAll();
        this.repository.delete(saved.getEmailAddressd());
        d_getAll();
        Set<Email> emails = this.repository.getAll();
        Assert.assertEquals(0, emails.size());
    }

    @Test
    public void d_getAll() {
        Set<Email> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, emails.size());
    }
}