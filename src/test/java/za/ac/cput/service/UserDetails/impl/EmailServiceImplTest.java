package za.ac.cput.service.UserDetails.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.Factory.UserDetails.EmailFactory;
import za.ac.cput.repository.UserDetails.EmailRepository;
import za.ac.cput.repository.UserDetails.impl.EmailRepositoryImpl;

import java.util.Set;

public class EmailServiceImplTest {

    private EmailRepository repository;
    private Email email;

    private Email getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmailRepositoryImpl.getRepository();
        this.email = EmailFactory.buildEmail("tauriq@gmail.com","1");
    }

    @Test
    public void create() {
        Email created = this.repository.create(this.email);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.email);
    }

    @Test
    public void read() {
        Email saved = getSaved();
        Email read = this.repository.read(saved.getEmailAddressd());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(saved, read);
    }

    @Test
    public void update() {
        String updateString = "henry@gmail.com";
        Email updated = new Email.Builder().copy(getSaved()).emailAddress(updateString).build();
        System.out.println("In update, about_to_updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(updateString, updated.getEmailAddressd());
    }

    @Test
    public void e_delete() {
        Email saved = getSaved();
        this.repository.delete(saved.getEmailAddressd());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Email> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, emails.size());
    }
}