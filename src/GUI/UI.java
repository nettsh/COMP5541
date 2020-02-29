import javax.swing.*; // basic Swing stuffs

import java.util.Arrays;

public class UI {

 public static void main(String[] args) {

  JFrame frame = new JFrame("Personal Diatery Manager Application");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  ApplicationController appController = new ApplicationController();
  appController.retrieveExistingFoodItems("../../FoodItemsToRead.txt");

  //System.out.println(Arrays.toString(appController.itemsHeader));
  frame.add(new PrimaryPanel(appController.itemsHeader, appController.items));

  frame.pack();
  frame.setLocationRelativeTo(null); // *** this will center your app ***
  frame.setVisible(true);

 }
}

