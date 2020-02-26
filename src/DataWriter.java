import java.util.ArrayList;
import java.io.PrintWriter;

public class DataWriter {

    //Format and save book file with column names and end of file indicator
    public static void saveFoodItems(String fileName, ArrayList<FoodItem> items) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println("Id|DiningType|Time|Name|Serving|Type|Retailer|Meal|Group");
            for(FoodItem item : items) {
                writer.println(item.toTxtFile());
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
