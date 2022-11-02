package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.Item;
import donkers.kevin.orderdk.domain.dto.ItemDto;
import donkers.kevin.orderdk.repositories.interfaces.ItemRepository;
import donkers.kevin.orderdk.security.SecurityService;
import donkers.kevin.orderdk.services.ItemService;
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
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Autowired
    SecurityService securityService;

    @BeforeEach
    void init() {
        itemRepository.addItem(new Item("1", "Banana","A long yellow fruit",2.00,10));
        itemRepository.addItem(new Item("2", "Orange","A round orange fruit",3.00,3));
        itemRepository.addItem(new Item("3", "Apple","A green or red fruit",1.50,4));
        itemRepository.addItem(new Item("4", "Kiwi","A furry fruit",0.75,100));
        itemRepository.addItem(new Item("5", "Of your labours","Dedication",25.00,1));
    }

    @Test
    void getAllItems_HappyPath() {

        List<ItemDto> expectedItems = List.of(
             //   new ItemDto(),
             //   new ItemDto();
        );


        ItemDto[] result = RestAssured
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
                .as(ItemDto[].class);

        assertThat(List.of(result)).isEqualTo(expectedItems);

    }

    @Test
    void getItemByID_HappyPath() {
      //  ItemDto expectedItems =
           //     new ItemDto();

        ItemDto result = RestAssured
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
                .as(ItemDto.class);

     //   assertThat(result).isEqualTo(expectedItems);
    }


    @Test
    void createItem_HappyPath() {
     //   ItemDto expectedItems =
       //         new ItemDto("1", "Mr", "Smithy", "MrSmithy@gmail.com", "Housestreet 22", "0498 76 87 98");

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

        ItemDto result = RestAssured
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
                .as(ItemDto.class);

      //  assertThat(result).isEqualTo(expectedItems);
    }
}
