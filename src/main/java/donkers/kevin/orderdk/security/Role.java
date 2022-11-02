package donkers.kevin.orderdk.security;

import static donkers.kevin.orderdk.security.Permission.*;

public enum Role {

    CUSTOMER(new Permission[]{
            CAN_ORDER_ITEMS, CAN_VIEW_OWN_ORDERS, CAN_RE_ORDER,
    }),
    ADMIN(new Permission[]{
            CAN_ADD_ITEM, CAN_UPDATE_ITEM, CAN_VIEW_ALL_CUSTOMERS, CAN_VIEW_CUSTOMER_BY_ID, CAN_VIEW_SHIPPING_TODAY, CAN_VIEW_STOCK
    }),
    GUEST(new Permission[]{

    });

    private Permission[] permissions;

    Role(Permission[] permissions) {
        this.permissions = permissions;
    }

    public Permission[] getPermissions() {
        return permissions;
    }
}
