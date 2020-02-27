import java.util.ArrayList;

public class ApplicationController {
    int inDiningCount;
    int outDiningCount;
    ArrayList<FoodItem> items;

    public ApplicationController() {
        this.inDiningCount = 0;
        this.outDiningCount = 0;
    }

    public ArrayList<FoodItem> retrieveExistingFoodItems(String fileName) {
        items = DataReader.getFoodItemsFromFile(fileName);
        for (FoodItem item : items){
            if(item.getDiningType() == "InDining")
                inDiningCount ++;
            else
                outDiningCount ++;
        }
        return items;
    }

    public Boolean saveFoodItems(String fileName) {
        DataWriter.saveFoodItems(fileName, items);
        return true;
    }

    public FoodItem createInDining(InDining inDiningItem) {
        items.add(inDiningItem);
        return inDiningItem;
    }

    public FoodItem createOutDining(OutDining outDiningItem) {
        items.add(outDiningItem);
        return outDiningItem;
    }

    public void add(InDining inDiningItem) {
        items.add(inDiningItem);
        inDiningCount ++;
    }

    public void add(OutDining outDiningItem) {
        items.add(outDiningItem);
        outDiningCount ++;
    }

    public void modify(InDining inDiningItem) {
        items.remove(inDiningItem);
        inDiningCount --;
    }

    public void modify(OutDining outDiningItem) {
        items.remove(outDiningItem);
        outDiningCount --;
    }
}
