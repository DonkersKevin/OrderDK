package donkers.kevin.orderdk.services.util;

import donkers.kevin.orderdk.domain.Customer.dto.CustomerResponse;

public class CustomerValidator {
    public static void checkCustomer(CustomerResponse customerDto) {
        checkCustomerRequiredFields(customerDto);
        checkEmailWithRegex(customerDto.getEmail());
    }

    private static void checkCustomerRequiredFields(CustomerResponse customerDto) {
        if (customerDto.getEmail() == null || customerDto.getEmail().equals("")) {
            throw new IllegalArgumentException("Provide an Email address please!");
        }
        if (customerDto.getLastName() == null || customerDto.getLastName().equals("")) {
            throw new IllegalArgumentException("Provide a City please!");
        }
        if (customerDto.getAddress() == null || customerDto.getAddress().equals("")) {
            throw new IllegalArgumentException("Provide a lastname please!");
        }
        if (customerDto.getPhoneNumber() == null || customerDto.getPhoneNumber().equals("")) {
            throw new IllegalArgumentException("Provide an INSS number please!");
        }
    }

    private static void checkEmailWithRegex(String email) {
        if (!email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid e-mail address...");
        }
    }
}
