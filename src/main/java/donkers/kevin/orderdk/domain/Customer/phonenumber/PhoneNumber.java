package donkers.kevin.orderdk.domain.Customer.phonenumber;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class PhoneNumber {
    @Enumerated(EnumType.STRING)
    private CountryCode countryCode;

    private String phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(CountryCode countryCode, String number) {
        this.countryCode = countryCode;
        this.phoneNumber = number;
    }
}
