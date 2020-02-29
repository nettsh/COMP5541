import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReader {

    public static String[] getColumnNames(String fileName) {

	String[] columns = {};
	
	try {
	  
	    FileInputStream inputStream = new FileInputStream(fileName);
	    InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader br = new BufferedReader(inputReader);
            String line = br.readLine();

	    columns = line.split("\\|");
	
	    return columns;
	
		} catch ( Exception e) {
	    e.printStackTrace();
	}

	return columns;
    }

    
    public static ArrayList<FoodItem> getFoodItemsFromFile(String fileName) {
        ArrayList<FoodItem> items = new ArrayList<FoodItem>();
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader br = new BufferedReader(inputReader);
            String line = br.readLine();
             while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] vals = line.split("\\|");
                if (vals[0].equals("Id")) {
                    continue;
                } else {
                    if (vals[1].equals("InDining")) {
                        InDining item = new InDining();
                        item.setId(vals[0]);
                        item.setDiningType(vals[1]);
                        item.setTime(vals[2]);
                        item.setName(vals[3]);
                        item.setServing(vals[4]);
                        item.setServing(vals[5]);
                        items.add(item);
                    } else {
                        OutDining item = new OutDining();
                        item.setId(vals[0]);
                        item.setDiningType(vals[1]);
                        item.setTime(vals[2]);
                        item.setRetailer(vals[6]);
                        item.setMeal(vals[7]);
                        item.setGroup(vals[8]);
                        items.add(item);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
