import java.util.*;

public class DietApp {

    public static void main(String[] args) {
        ApplicationController appController = new ApplicationController();
        //demo read existing items from file and add one indining and one outdining
        appController.retrieveExistingFoodItems("FoodItemsToRead.txt");
        InDining inDiningItem = new InDining("003", "2020-01-02 1:00AM", true, "Rice", "200g","Carb");
        OutDining outDiningItem = new OutDining("004","2020-02-02 2:00PM", false, "Second Cup","Cookies", "Main Dish");
        appController.add(inDiningItem);
        appController.add(outDiningItem);
        //Modify uses Id to match
        inDiningItem.setServing("1kg");
        appController.modify(inDiningItem);
        appController.saveFoodItems("FoodItemsSaved.txt");
    }
}
