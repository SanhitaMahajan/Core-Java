package tester;
import java.util.Map;
import java.util.Scanner;
import com.app.Order;
import com.app.OrderStatus;
import com.app.Pet;
import static Utils.PetCollectionUtils.*;
import static  Utils.UserCollection.*;
import static Utils.OrderCollectionUtils.*;
import custome_exceptions.AuthorizationException;
import static Utils.ValidationRules.*;

import com.app.User;
public class Tester {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Map<Integer, Pet> petMap = populatePetData();
            Map<String,User> userMap = populateUserData();
            Map<Integer, Order> orderMap = populateOrderData();
try {
    boolean isAdmin = false;
    boolean isUser = false;
    boolean flag = true;

    // check if admin is login or user is login
    System.out.println("Enter loginID and password");
    User loginUser = loginValidation(sc.next(), sc.next(), userMap);
    if(loginUser.getLoginId().equals("admin")){
        isAdmin = true;
        System.out.println("Admin login successfully....");
    }
    else{
        isUser = true;
        System.out.println("User login successfully....");
    }

    while(flag){

        if(isAdmin){
            showAdminMenu();
            System.out.println("Enter your choice");
            switch (sc.nextInt()){
                case 1: // add new pet - String name, PetCategory category, int unitPrice, int stocks
                    System.out.println("Enter pet details - name, pet category , unit price , stocks ");
                    Pet p = validateInputs(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
                    petMap.put(p.getPetId(),p);
                    System.out.println("Pet details added successfully....");
                    break;
                case 2 : // update pet details
                    System.out.println("Enter pet id to update details ");
                    updatePetDetails(sc.nextInt(),petMap);
                    break;
                case 3: // update order status
                    System.out.println("Enter order id to update status - ");
                    int checkId =sc.nextInt();
                    Order order = orderMap.get(checkId);
                    if(order!=null){
                        System.out.println("Enter updated status - ");
                        String statusString = sc.next();
                        OrderStatus updatedStatus = OrderStatus.valueOf(statusString.toUpperCase());
                        order.setStatus(updatedStatus);
                        System.out.println("Status updated successfully");
                    }
                    else{
                        throw new AuthorizationException("Order ID not found");
                    }
                    break;
                case 4 : // display all orders
                    System.out.println("All order details are ");
                    orderMap.values().stream().forEach(o->System.out.println(o));
                    break;
                case 5: // display all available pets
                    System.out.println("All available pets are - ");
                    petMap.values().stream().filter(pt->pt.getStocks()>0).forEach(pt->System.out.println(pt));
                    break;
                case 0:
                    System.out.println("Exiting......");
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input...Please retry");
            }
        }

        if(isUser){
            showUserMenu();
            System.out.println("Enter your choice");
            switch (sc.nextInt()){
                case 1: // display all available pets
                    System.out.println("All available pets are - ");
                    petMap.values().stream().filter(p->p.getStocks()>0).forEach(p->System.out.println(p));
                    break;
                case 2 : // order a pet
                    System.out.println("Enter the Pet Id you want to order");
                    orderAPet(sc.nextInt(),petMap,orderMap);
                    break;
                case 3: // check order status by Oder Id
                    System.out.println("Enter order id to check status - ");
                    int checkId =sc.nextInt();
                    Order order = orderMap.get(checkId);
                    if(order!=null){
                        System.out.println(order.getStatus());
                    }
                   else{
                        throw new AuthorizationException("Order ID not found");
                    }
                    break;
                case 0:
                    System.out.println("Exiting......");
                    flag = false;
                    break;
                case 4 : // display all ordered pets
                    orderMap.values().stream().forEach(oi->System.out.println(oi));
                    break;
                default:
                    System.out.println("Invalid input...Please retry");
            }
        }

    }
}catch(Exception e){
    System.out.println(e);
}
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}