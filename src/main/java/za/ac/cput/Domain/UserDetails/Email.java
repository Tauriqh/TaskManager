package za.ac.cput.Domain.UserDetails;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@EntityScan
public class Email {
    private String emailAddress;
    private String userId;

    private Email(){}

    private Email(Builder builder) {
        this.emailAddress = builder.emailAddress;
        this.userId = builder.userId;
    }

    public String getEmailAddressd() {
        return emailAddress;
    }

    public String getUserId() {
        return userId;
    }

    public static class Builder {
        private String emailAddress;
        private String userId;

        public Builder emailAddress( String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder userId( String userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Email email) {
            this.emailAddress = email.emailAddress;
            this.userId = email.userId;
            return this;
        }

        public Email build() {
            return new Email(this);
        }

    }

    @Override
    public String toString() {
        return "Email{" +
                "emailAddress='" + emailAddress + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return emailAddress.equals(email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}
