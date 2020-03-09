import javax.swing.*; // basic Swing stuffs

import java.util.Arrays;

public class UI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Personal Diatery Manager Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ApplicationController appController = new ApplicationController();
        appController.retrieveExistingFoodItems("FoodItemsToRead_r2.txt");

        //Demo add Indining and OutDining
        Time time = new Time("Wed", "2020-01-02", "1:00AM");
        NutritionFacts nutFacts = new NutritionFacts(400,2,4,6,8,10);
        InDining inDiningItem = new InDining("11111111", time, true, "Rice", "200g","Carb",nutFacts);
        OutDining outDiningItem = new OutDining("22222222",time, false, "Second Cup","Cookies", "Main Dish");
        appController.add(inDiningItem);
        appController.add(outDiningItem);
        appController.saveFoodItems("FoodItemsSaved_r2.txt");

        frame.add(new PrimaryPanel(appController));
        //  frame.add(new PrimaryPanel());

        frame.pack();
        frame.setLocationRelativeTo(null); // *** this will center your app ***
        frame.setSize(900,400);
        frame.setVisible(true);

    }
}

