package donkers.kevin.orderdk.controllers;

import donkers.kevin.orderdk.domain.dto.ItemDto;
import donkers.kevin.orderdk.services.ItemService;
import donkers.kevin.orderdk.security.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto getItemById(@PathVariable String id){
        log.info("Getting item by id : " + id);
        return itemService.getItemById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDto> getAllItems(){
        log.info("Getting all items...");
        return itemService.getAllItems();
    }

    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        log.info("Adding new item...");
        return itemService.addItem(itemDto);
    }
}
