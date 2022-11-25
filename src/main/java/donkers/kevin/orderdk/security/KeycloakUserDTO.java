package donkers.kevin.orderdk.security;

public record KeycloakUserDTO(String userName, String password, Role role) {
}
