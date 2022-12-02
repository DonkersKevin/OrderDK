package donkers.kevin.orderdk.controllers;


import donkers.kevin.orderdk.domain.Item.dto.ItemResponse;
import donkers.kevin.orderdk.domain.Item.dto.NewItem;
import donkers.kevin.orderdk.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemResponse> getAllItems(){
        log.info("Getting all items...");
        return itemService.getAllItems();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItemById(@PathVariable String id){
        log.info("Getting item by id : " + id);
        return itemService.getItemById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('CAN_ADD_ITEM')")
    public ItemResponse addItem(@RequestBody NewItem newItem){
        log.info("Adding new item...");
        return itemService.addItem(newItem);
    }
}
