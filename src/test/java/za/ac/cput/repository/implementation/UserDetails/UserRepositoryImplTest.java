package za.ac.cput.repository.implementation.UserDetails;

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
public class UserRepositoryImplTest {

    private UserRepository repository;
    private User user;

    private User getSavedUser() {
        Set<User> savedUsers = this.repository.getAll();
        return savedUsers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = UserRepositoryImpl.getRepository();
        this.user = UserFactory.buildUser("John","Doe");
    }

    @Test
    public void a_create() {
        User userInfo = this.repository.create(this.user);
        d_getAll();
        Assert.assertSame(userInfo, this.user);
    }

    @Test
    public void b_read() {
        User savedUser = getSavedUser();
        User read = this.repository.read(savedUser.getUserId());
        //System.out.println("In read, read = " + read);
        Assert.assertEquals(savedUser, read);
        d_getAll();
    }

    @Test
    public void c_update() {
        String updateString = "Hendricks";
        User user = new User.Builder().copy(getSavedUser()).lastName(updateString).build();
        //System.out.println("In update, about_to_updated = " + user);
        User updated = this.repository.update(user);
        //System.out.println("In update, updated = " + updated);
        Assert.assertSame(updateString, updated.getLastName());
        d_getAll();
    }

    @Test
    public void e_delete() {
        User savedUser = getSavedUser();
        d_getAll();
        this.repository.delete(savedUser.getUserId());
        d_getAll();
        Set<User> users = this.repository.getAll();
        Assert.assertEquals(0, users.size());
    }

    @Test
    public void d_getAll() {
        Set<User> all = this.repository.getAll();
        //System.out.println("In getAll, all = " + all);
        //Assert.assertEquals(1, users.size());
    }
}