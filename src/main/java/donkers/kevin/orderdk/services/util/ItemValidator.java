package donkers.kevin.orderdk.services.util;


import donkers.kevin.orderdk.domain.Item.dto.NewItem;

public class ItemValidator {
    public static void checkItemRequiredFields(NewItem newItem) {
        if (newItem.getName() == null || newItem.getName().equals("")) {
            throw new IllegalArgumentException("Provide a name please!");
        }
        if (newItem.getDescription() == null || newItem.getDescription().equals("")) {
            throw new IllegalArgumentException("Provide a description please!");
        }
        //todo fix
        /*
        if (newItem.getPrice() < 0) {
            throw new IllegalArgumentException("Provide a valid price per unit.");
        }
         */
        if (newItem.getStock() < 0) {
            throw new IllegalArgumentException("Provide a valid stock amount.");
        }
    }
}
