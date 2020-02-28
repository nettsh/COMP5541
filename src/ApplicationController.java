import java.util.ArrayList;

public class ApplicationController {
    int inDiningCount;
    int outDiningCount;
    ArrayList<FoodItem> items;

    public ApplicationController() {
        this.inDiningCount = 0;
        this.outDiningCount = 0;
        items = new ArrayList<FoodItem>();
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

    public void remove(InDining inDiningItem) {
        items.remove(inDiningItem);
        inDiningCount --;
    }

    public void remove(OutDining outDiningItem) {
        items.remove(outDiningItem);
        outDiningCount --;
    }

    public void modify(InDining inDiningItemToModify) {
        for (FoodItem item: items) {
            if (item.getId() == inDiningItemToModify.getId()) {
                ((InDining)item).setTime(inDiningItemToModify.getTime());
                ((InDining)item).setServing(inDiningItemToModify.getServing());
                ((InDining)item).setName(inDiningItemToModify.getName());
                ((InDining)item).setType(inDiningItemToModify.getType());
            }
        }
    }

    public void modify(OutDining onDiningItemToModify) {
        for (FoodItem item: items) {
            if (item.getId() == onDiningItemToModify.getId()) {
                ((OutDining)item).setTime(onDiningItemToModify.getTime());
                ((OutDining)item).setRetailer(onDiningItemToModify.getRetailer());
                ((OutDining)item).setMeal(onDiningItemToModify.getMeal());
                ((OutDining)item).setGroup(onDiningItemToModify.getGroup());
            }
        }
    }
}
