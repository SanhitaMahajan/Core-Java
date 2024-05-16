package Utils;
import com.app.Order;
import java.util.HashMap;
import java.util.Map;
import static com.app.OrderStatus.*;
import  com.app.Pet;
import custome_exceptions.MainError;
import custome_exceptions.OutOfStockException;

import java.util.Scanner;
import java.util.Scanner.*;
public class OrderCollectionUtils {

    public static Map<Integer, Order> populateOrderData(){
        Map<Integer,Order> map = new HashMap<>();
        map.put(1,new Order(1, 101,5,PLACED));
        map.put(2,new Order(2,102, 10, IN_PROCESS));
        map.put(3,new Order(3, 103, 3, COMPLETED));
        return map;
    }

    private static int counter = 100;
    public static void orderAPet(int petId, Map<Integer, Pet> petMap,  Map<Integer, Order> orderMap) throws MainError, OutOfStockException{

//         1. pet ID validation
        Pet orderedPet = petMap.values().stream().filter(p->p.getPetId()==petId).findFirst().orElse(null);
        if(orderedPet==null){
            throw new MainError("Pet not found with given id");
        }

//        2. quantity validation
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the quantity ");
        int quantity = sc.nextInt();
        sc.nextLine();
        if(orderedPet.getStocks()<quantity){
            throw new OutOfStockException("Sorry, the requested quantity exceeds the available stocks.");
        }

//        calculations
        double totalAmount = orderedPet.getUnitPrice()*quantity;
        System.out.println("Total Amount : $"+totalAmount);

        System.out.println("Confirm order (Y/N) ? ");
        String confrimation = sc.next();
        if("Y".equalsIgnoreCase(confrimation)){
            orderedPet.setStocks(orderedPet.getStocks()-quantity);
            counter++;
            orderMap.put(counter, new Order(counter,petId,quantity,PLACED));
            System.out.println("Order placed successfully. Your order Id is: " + counter);
        }
        else{
            System.out.println("Order cancelled");
        }
    }
}
