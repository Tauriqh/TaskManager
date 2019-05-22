package za.ac.cput.Factory.UserDetails;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.UserDetails.Email;
import za.ac.cput.Factory.UserDetails.EmailFactory;

public class EmailFactoryTest {

    private String emailAddress;
    private String userId;

    @Before
    public void setUp() throws Exception {
        this.emailAddress = "tauriq@gmail.com";
        this.userId = "1";
    }
    @Test
    public void buildEmail() {
        Email email = EmailFactory.buildEmail(emailAddress, userId);
        Assert.assertNotNull(email.getEmailAddressd());
        Assert.assertNotNull(email);
    }
}