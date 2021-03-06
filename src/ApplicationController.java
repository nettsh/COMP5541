import java.util.ArrayList;

public class ApplicationController {
    static int inDiningCount;
    static int outDiningCount;
    static public ArrayList<FoodItem> items;
    static public String[] itemsHeader;
    
    public ApplicationController() {
        this.inDiningCount = 0;
        this.outDiningCount = 0;
        items = new ArrayList<FoodItem>();
    }
    
    public ArrayList<FoodItem> retrieveExistingFoodItems(String fileName) {
        items = DataReader.getFoodItemsFromFile(fileName);
    
	itemsHeader = DataReader.getColumnNames(fileName);
    
        for (FoodItem item : items){
            if(item.getDiningType() == "InDining")
                inDiningCount ++;
            else
                outDiningCount ++;
        }
        return items;
    }

    static public Boolean saveFoodItems(String fileName) {
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

    static public void add(FoodItem foodItem) {
	items.add(foodItem);

	if (foodItem.getDiningType().equals("OutDining"))
	    outDiningCount ++;
	else if (foodItem.getDiningType().equals("InDining"))
	    inDiningCount ++;
	    
	
    }

    public void removeById(String id) {
        for (int i =0; i<items.size(); i++) {
            if (items.get(i).getId() == id)
                items.remove(i);
        }
    }

    public void setEatenFlagById(String id, Boolean eatenFlag) {
        for (int i =0; i<items.size(); i++) {
            if (items.get(i).getId() == id)
                items.get(i).setEaten(eatenFlag);
        }
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
