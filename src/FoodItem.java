import java.util.HashMap;
import java.util.Map;

public abstract class FoodItem {
    String time;
    String id;
    String diningType;
    Boolean eaten;
    
    String[] all;
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getDiningType() {
        return diningType;
    }

    public void setDiningType(String diningType) {
        this.diningType = diningType;
    }

    public void setEaten(Boolean eaten) {
        this.eaten = eaten;
    }

    public Boolean getEaten() {
        return eaten;
    }

    public Map<String,String> getAll() {
	
	Map<String,String> common = new HashMap<>();

	common.put("Time", time);
	common.put("Id", id);
	common.put("DiningType", diningType);

	return common;
    }

    public abstract String toTxtFile();
}
