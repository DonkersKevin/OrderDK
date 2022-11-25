package donkers.kevin.orderdk.domain.Customer.Address;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;


@Data
@Embeddable
public class PostalCode {

    @NotBlank
    private String postalCode;

    @Column(name = "city")
    private String city;

}
