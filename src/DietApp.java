import java.util.*;

public class DietApp {

    public static void main(String[] args) {
        ApplicationController appController = new ApplicationController();
        //demo read existing items from file and add one indining and one outdining
        appController.retrieveExistingFoodItems("FoodItemsToRead_r2.txt");
        
        //Demo add Indining and OutDining
        Time time = new Time("Wed", "2020-01-02", "1:00AM");
        NutritionFacts nutFacts = new NutritionFacts(400,2,4,6,8,10);
        InDining inDiningItem = new InDining("11111111", time, true, "Rice", "200g","Carb",nutFacts);
        OutDining outDiningItem = new OutDining("22222222",time, false, "Second Cup","Cookies", "Main Dish");
        appController.add(inDiningItem);
        appController.add(outDiningItem);
        appController.saveFoodItems("FoodItemsSaved_r2.txt");
    }
}
