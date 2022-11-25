package donkers.kevin.orderdk.domain.Item;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Currency;

@Embeddable
@Getter
public class Price {

    @NotBlank
    @Column(name = "unitPrice")
    private double unitPrice;

    @NotBlank
    @Column(name = "currency")
    private Currency currency;
}
