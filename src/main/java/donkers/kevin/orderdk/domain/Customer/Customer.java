package donkers.kevin.orderdk.domain.Customer;

import donkers.kevin.orderdk.domain.Customer.Address.Address;
import donkers.kevin.orderdk.domain.Customer.phonenumber.PhoneNumber;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMERS")
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @NotNull
    @Embedded
    private PhoneNumber phoneNumber;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
