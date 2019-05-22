package za.ac.cput.Factory.UserDetails;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.Factory.UserDetails.UserFactory;

public class UserFactoryTest {

    private String userId;
    private String firstName;
    private String lastName;

    @Before
    public void setUp() throws Exception {
       this.userId = "1";
       this.firstName = "John";
       this.lastName = "Doe";
    }

    @Test
    public void buildUser() {
        User user = UserFactory.buildUser(userId, firstName, lastName);
        Assert.assertNotNull(user.getUserId());
        Assert.assertNotNull(user);
    }
}