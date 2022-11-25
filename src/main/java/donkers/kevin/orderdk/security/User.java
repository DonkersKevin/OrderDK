package donkers.kevin.orderdk.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    private String firstName;
    private String lastName;
    private UsernamePassword usernamePassword;
    private Role role;

    public User(String firstName, String lastName, UsernamePassword usernamePassword, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.usernamePassword = usernamePassword;
        this.role = role;
    }

    public boolean doesPasswordMatch(String password) {
        return usernamePassword.getPassword().equals(password);
    }

    public boolean isAllowedTo(Permission permission) {
        return Arrays.stream(role.getPermissions()).toList().contains(permission);
    }

    public UsernamePassword getUsernamePassword() {
        return usernamePassword;
    }

     */
}

