package donkers.kevin.orderdk.domain.Customer.dto;

import donkers.kevin.orderdk.domain.Customer.Address.Address;
import donkers.kevin.orderdk.domain.Customer.phonenumber.PhoneNumber;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private PhoneNumber phoneNumber;

    public CustomerResponse(Long id, String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}


