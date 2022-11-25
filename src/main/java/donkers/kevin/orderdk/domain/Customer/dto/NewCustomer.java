package donkers.kevin.orderdk.domain.Customer.dto;

import donkers.kevin.orderdk.domain.Customer.Address.Address;
import donkers.kevin.orderdk.domain.Customer.phonenumber.PhoneNumber;
import lombok.Getter;

@Getter
public class NewCustomer {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private PhoneNumber phoneNumber;

    public NewCustomer(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
