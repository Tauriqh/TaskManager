package za.ac.cput.service.UserDetails.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.Factory.UserDetails.UserFactory;
import za.ac.cput.repository.UserDetails.UserRepository;
import za.ac.cput.repository.UserDetails.impl.UserRepositoryImpl;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest {

    private UserRepository repository;
    private User user;

    private User getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = UserRepositoryImpl.getRepository();
        this.user = UserFactory.buildUser("1","John","Doe");
    }

    @Test
    public void a_create() {
        User created = this.repository.create(this.user);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.user);
    }

    @Test
    public void b_read() {
        User saved = getSaved();
        User read = this.repository.read(saved.getUserId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update() {
        String  newLastName = "Hendricks";
        User updated = new User.Builder().copy(getSaved()).lastName(newLastName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLastName, updated.getLastName());
    }

    @Test
    public void d_getAll() {
        Set<User> users = this.repository.getAll();
        System.out.println("In getall, all = " + users);
    }

    @Test
    public void e_delete() {
        User saved = getSaved();
        this.repository.delete(saved.getUserId());
        d_getAll();
    }
}