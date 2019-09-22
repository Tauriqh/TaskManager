package za.ac.cput.Factory.UserDetails;

import za.ac.cput.Domain.UserDetails.User;
import za.ac.cput.util.Misc;

public class UserFactory {
    public static User buildUser(String firstName, String lastName) {
        return new User.Builder()
                .userId(Misc.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
