package Utils;
import com.app.User;
import java.util.HashMap;
import java.util.Map;
import  custome_exceptions.AuthenticationException;
public class UserCollection {
    public static Map<String, User> populateUserData(){
        Map<String,User> userMap = new HashMap<>();
        userMap.put("admin",new User("admin","admin"));
        userMap.put("c1",new User("c1","c1"));
        return userMap;
    }
    public static User loginValidation(String id, String pass, Map<String, User> userMap) throws AuthenticationException{
        if (userMap.containsKey(id)) {
            User user = userMap.get(id);
            if (user.getPassword().equals(pass)) {
                return user;
            } else {
                // Password doesn't match
                throw new AuthenticationException("Invalid Login");
            }
        } else {
            throw new AuthenticationException("Invalid Login");
        }
    }

    public static void showAdminMenu(){
        System.out.println("1. Add a new Pet");
        System.out.println("2. Update Pet Details");
        System.out.println("3. Update order status");
        System.out.println("4. Display all orders");
        System.out.println("5. Display all available pets");
        System.out.println("0. Logout");
    }

    public static void showUserMenu(){
        System.out.println("1. Display all available pets");
        System.out.println("2. Order a pet");
        System.out.println("3. Check order status by Order Id");
        System.out.println("4. Display all ordered pets");
        System.out.println("0. Logout");
    }

}
