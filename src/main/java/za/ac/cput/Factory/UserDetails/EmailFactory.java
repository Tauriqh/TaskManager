package za.ac.cput.Factory.UserDetails;

import za.ac.cput.Domain.UserDetails.Email;

public class EmailFactory {
    public static Email buildEmail(String emailAddress, String userId) {
        return new Email.Builder()
                .emailAddress(emailAddress)
                .userId(userId)
                .build();
    }
}
