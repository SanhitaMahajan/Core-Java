package Utils;
import com.app.Pet;
import com.app.PetCategory;
import custome_exceptions.MainError;

public class ValidationRules {


//   inputs -  String name, PetCategory category, int unitPrice, int stocks
    public static Pet validateInputs(String name, String category, int price, int stock) throws IllegalArgumentException, MainError
    {
        PetCategory p = validatePetCategory(category);
        if(price<0) throw new MainError("Price should be greater than 0");
        if(stock<0) throw new MainError("stock should be atleast 1");
        return new Pet(name,p,price,stock);
    }

    public static PetCategory  validatePetCategory(String b) throws IllegalArgumentException {
        return PetCategory.valueOf(b.toUpperCase());
    }
}
