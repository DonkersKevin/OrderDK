package donkers.kevin.orderdk.domain.Customer.phonenumber;

import lombok.Getter;

@Getter
public enum CountryCode {

    BELGIUM("+32"),
    FRANCE("+33"),
    NETHERLANDS("+31");

    private final String countryCode;

    CountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
