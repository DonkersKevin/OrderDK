package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Customer;
import donkers.kevin.orderdk.domain.dto.CustomerDto;
import donkers.kevin.orderdk.repositories.interfaces.CustomerRepository;
import donkers.kevin.orderdk.services.CustomerService;
import donkers.kevin.orderdk.services.SecurityService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    SecurityService securityService;

    @BeforeEach
    void init() {
        //Hardcoded
        //   customerRepository.addCustomer(new Customer("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98"));
        customerRepository.addCustomer(new Customer("2", "Mrs", "Smith", "MsSmith@gmail.com", "Manorstreet 22", "0473 63 33 33"));
    }

    @Test
    void getAllCustomers_HappyPath() {

        List<CustomerDto> expectedCustomers = List.of(
                new CustomerDto("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98"),
                new CustomerDto("2", "Mrs", "Smith", "MsSmith@gmail.com", "Manorstreet 22", "0473 63 33 33"));


        CustomerDto[] result = RestAssured
                .given()
                .baseUri("http://localhost")
                .port(port)

                .when()
                .accept(ContentType.JSON)
                .get("/customers")

                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(CustomerDto[].class);

        assertThat(List.of(result)).isEqualTo(expectedCustomers);

    }

    @Test
    void getCustomerByID_HappyPath() {
        CustomerDto expectedCustomers =
                new CustomerDto("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98");

        CustomerDto result = RestAssured
                .given()
                .baseUri("http://localhost")
                .port(port)

                .when()
                .accept(ContentType.JSON)
                .get("/customers/1")

                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(CustomerDto.class);

        assertThat(result).isEqualTo(expectedCustomers);
    }


    @Test
    void createCustomer_HappyPath() {
        CustomerDto expectedCustomers =
                new CustomerDto("1", "Mr", "Smithy", "MrSmithy@gmail.com", "Housestreet 22", "0498 76 87 98");

        String requestBody =
                """
                         {
                             "id": "1",
                             "firstName": "Mr",
                             "lastName": "Smithy",
                             "email": "MrSmithy@gmail.com",
                             "address": "Housestreet 22",
                             "phoneNumber": "0498 76 87 98"
                         }
                        """;

        CustomerDto result = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri("http://localhost")
                .port(port)

                .when()
                .body(requestBody)
                .accept(ContentType.JSON)
                .post("/customers/add")

                .then()
                //       .assertThat()
                //       .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(CustomerDto.class);

        assertThat(result).isEqualTo(expectedCustomers);
    }

}