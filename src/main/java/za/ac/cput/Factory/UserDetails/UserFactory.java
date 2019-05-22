package za.ac.cput.Factory.UserDetails;

import za.ac.cput.Domain.UserDetails.User;

public class UserFactory {
    public static User buildUser(String userId, String firstName, String lastname) {
        return new User.Builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastname)
                .build();
    }
}
