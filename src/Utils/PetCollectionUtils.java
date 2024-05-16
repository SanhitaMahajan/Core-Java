package Utils;
import com.app.Pet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

import static com.app.PetCategory.*;

import com.app.PetCategory;
import custome_exceptions.MainError;
import static Utils.ValidationRules.*;
public class PetCollectionUtils {
    public static Map<Integer, Pet> populatePetData(){
        Map<Integer,Pet> map = new HashMap<>();
        map.put(101,new Pet("Bull Dog",DOG,1000,10));
        map.put(102,new Pet("Cat",CAT,1500,20));
        map.put(103,new Pet("Start Fish",FISH,5000,5));
        map.put(104,new Pet("XYZ Fish",FISH,5000,0));
        return map;
    }

    public static void updatePetDetails(int petId, Map<Integer,Pet> petMap) throws MainError {

        Pet petToUpdate = petMap.get(petId);

        if(petToUpdate==null){
            throw new MainError("Pet ID "+petToUpdate+" not found");
        }

        System.out.println("Current details of the pet:");
        System.out.println("Pet ID: " + petToUpdate.getPetId());
        System.out.println("Name: " + petToUpdate.getName());
        System.out.println("Category: " + petToUpdate.getCategory());
        System.out.println("Unit Price: " + petToUpdate.getUnitPrice());
        System.out.println("Stocks: " + petToUpdate.getStocks());

        Scanner sc = new Scanner(System.in);

        System.out.println("What you want to update ?");
        System.out.println("1. Price");
        System.out.println("2. Stock");
        System.out.println("0. Cancel update");
        System.out.println("Enter your choice");
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Unit Price: ");
                    int newUnitPrice = sc.nextInt();
                    petToUpdate.setUnitPrice(newUnitPrice);
                    System.out.println("Pet details updated successfully.");
                    break;
                case 2:
                    System.out.print("Stocks: ");
                    int newStocks = sc.nextInt();
                    petToUpdate.setStocks(newStocks);
                    System.out.println("Pet details updated successfully.");
                    break;
                case 0:
                    System.out.println("Cancelling Update.......");
                    break;
            }
    }
}

//        Pet petToUpdate = petMap.values().stream()
//                .filter(pet -> pet.getPetId() == petId)
//                .findFirst()
//                .orElse(null);


//        System.out.print("Name: ");
//        String newName = sc.next();
//
//        System.out.print("Category (CAT, DOG, RABBIT, FISH): ");
//        String categoryStr = sc.next();
//        PetCategory newCategory = validatePetCategory(categoryStr);