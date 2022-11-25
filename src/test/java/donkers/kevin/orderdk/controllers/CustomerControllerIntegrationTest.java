package donkers.kevin.orderdk.controllers;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerIntegrationTest {
    /*

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
        //   customerRepository.addCustomer(new Customer("0", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98"));
        customerRepository.addCustomer(Customer.createCustomerWithprovidedId("0", "Mrs", "Smith", "MsSmith@gmail.com", "Manorstreet 22", "0473 63 33 33"));
    }

    @Test
    void getAllCustomers_HappyPath() {

        List<CustomerResponse> expectedCustomers = List.of(
                new CustomerResponse("0", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98"),
                new CustomerResponse("0", "Mrs", "Smith", "MsSmith@gmail.com", "Manorstreet 22", "0473 63 33 33"));


        CustomerResponse[] result = RestAssured
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
                .as(CustomerResponse[].class);

        assertThat(List.of(result)).isEqualTo(expectedCustomers);

    }

    @Test
    void getCustomerByID_HappyPath() {
        CustomerResponse expectedCustomers =
                new CustomerResponse("1", "Mr", "Smith", "MrSmith@gmail.com", "Manorstreet 22", "0498 76 87 98");

        CustomerResponse result = RestAssured
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
                .as(CustomerResponse.class);

        assertThat(result).isEqualTo(expectedCustomers);
    }


    @Test
    void createCustomer_HappyPath() {
        CustomerResponse expectedCustomers =
                new CustomerResponse("1", "Mr", "Smithy", "MrSmithy@gmail.com", "Housestreet 22", "0498 76 87 98");

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

        CustomerResponse result = RestAssured
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
                .as(CustomerResponse.class);

        assertThat(result).isEqualTo(expectedCustomers);
    }

     */

}