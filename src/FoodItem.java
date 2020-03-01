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

    public Map<String,Object> getAll() {
	
	Map<String,Object> all  = new HashMap<>();

	all.put("Time", time);
	all.put("Id", id);
	all.put("DiningType", diningType);
	all.put("Eaten", eaten);

	return all;
    }

    public abstract String toTxtFile();
}
