package donkers.kevin.orderdk.domain.Customer.Address;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ADDRESSES")
@Data
@NotBlank
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "streetname")
    private String streetName;

    @NotBlank
    @Column(name = "housenumber")
    private String houseNumber;

    @Embedded
    private PostalCode postalCode;

    @Column(name = "country")
    private String country;

}
