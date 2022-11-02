package donkers.kevin.orderdk.security;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> userList;

    public UserRepository() {
        this.userList =
                new ArrayList<User>(List.of(
                        new User("Fred"  ,"Flintstone",new UsernamePassword("Fred"  ,"jabbedabbedoo"),Role.GUEST),
                        new User("Barney","Rubble"    ,new UsernamePassword("Barney","yeehaw")       ,Role.CUSTOMER),
                        new User("Wilma" ,"Flintstone",new UsernamePassword("Wilma" ,"Naughty")      ,Role.CUSTOMER),
                        new User("Betty" ,"Rubble"    ,new UsernamePassword("Betty" ,"Wilma")        ,Role.CUSTOMER),
                        new User("Kevin" ,"Donkers"   ,new UsernamePassword("Kevin" ,"doobedoodoo")  ,Role.ADMIN)
                ));
    }

    public User getUser(String username) {
        return userList.stream()
                .filter(u -> u.getUsernamePassword().getUsername().equals(username))
                .findFirst()
                .orElseThrow();
    }
}
