package za.ac.cput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import za.ac.cput.domain.userDetails.User;

@Controller("userWebValidator")
public class WebValidator {

    public WebValidator(){
    }

    public void validate(final Object object, final Errors errors) {
        final User user = (User) object;

        if (user == null) {
            errors.reject("error.missing.object");
        }else if(user.getFirstName().equals("")){
            errors.reject("error.notnull");
        }
    }
}
