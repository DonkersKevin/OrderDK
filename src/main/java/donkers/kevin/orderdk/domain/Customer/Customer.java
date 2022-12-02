package donkers.kevin.orderdk.domain.Customer;

import donkers.kevin.orderdk.domain.Customer.Address.Address;
import donkers.kevin.orderdk.domain.Customer.phonenumber.PhoneNumber;
import donkers.kevin.orderdk.security.Role;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Builder
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    @NotNull
    @Embedded
    private PhoneNumber phoneNumber;

    @NotNull
    @Column(name = "security_role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank
    private String username;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber, Role role, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.username = username;
    }

    public Customer(Long id, String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber, Role role, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.username = username;
    }
}
