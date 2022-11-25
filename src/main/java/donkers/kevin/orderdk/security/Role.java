package donkers.kevin.orderdk.security;

import com.google.common.collect.Lists;

import java.util.List;

import static donkers.kevin.orderdk.security.Permission.*;

public enum Role {

    CUSTOMER("customer",
            CAN_ORDER_ITEMS,
            CAN_VIEW_OWN_ORDERS,
            CAN_RE_ORDER),

    ADMIN("admin",
            CAN_ADD_ITEM,
            CAN_UPDATE_ITEM,
            CAN_VIEW_ALL_CUSTOMERS,
            CAN_VIEW_CUSTOMER_BY_ID,
            CAN_VIEW_SHIPPING_TODAY,
            CAN_VIEW_STOCK),

    GUEST("guest", CAN_REGISTER);

    private final String label;

    private final List<Permission> permissions;

    Role(String label, Permission... permissions) {
        this.label = label;
        this.permissions = Lists.newArrayList(permissions);
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public String getLabel() {
        return label;
    }
}


