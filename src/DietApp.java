import java.util.*;

public class DietApp {

    public static void main(String[] args) {
//        ArrayList<FoodItem> itemsToSave = new ArrayList<FoodItem>();
//        InDining inDiningItem = new InDining("001", "2020-01-01 1:00AM", "Cake", "200g","Carb");
//        OutDining outDiningItem = new OutDining("002","2020-02-01 2:00PM","A&W","Frites", "Main Dish");
//        itemsToSave.add(inDiningItem);
//        itemsToSave.add(outDiningItem);
        ApplicationController appController = new ApplicationController();
        appController.retrieveExistingFoodItems("FoodItemsToRead.txt");
        appController.saveFoodItems("FoodItemsSaved.txt");
    }
}
