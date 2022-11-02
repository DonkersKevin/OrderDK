package donkers.kevin.orderdk.security;

import donkers.kevin.orderdk.exceptions.UnauthorizatedException;
import donkers.kevin.orderdk.exceptions.UnknownUserException;
import donkers.kevin.orderdk.exceptions.WrongPassWordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {

    private final Logger log = LoggerFactory.getLogger(SecurityService.class);

    private UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateAuthorization(String authorization, Permission permission){
        UsernamePassword usernamePassword = getUsernamePassword(authorization);
        User user = userRepository.getUser(usernamePassword.getUsername());
        if(user == null){
            log.error("User is null - " + usernamePassword.getUsername());
            throw new UnknownUserException();
        }
        if(!user.doesPasswordMatch(usernamePassword.getPassword())){
            log.error("Password does not match");
            throw new WrongPassWordException();
        }
        if(!user.isAllowedTo(permission)){
            log.error("User " + usernamePassword.getUsername() + " does not have acces to " + permission);
            throw new UnauthorizatedException();
        }
    }

    private UsernamePassword getUsernamePassword(String authorization){
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("basic".length())));
        String username = decodedUsernameAndPassword.substring(0,decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":"+1));
        return new UsernamePassword(username,password);
    }
}
