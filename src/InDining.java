import java.util.HashMap;
import java.util.Map;

public class InDining extends FoodItem {
    String name;
    String serving;
    String type;
    NutritionFacts nutritionFacts;

    public InDining(){}

    public InDining(String id, Time time, Boolean eaten, String name, String serving, String type,
                    NutritionFacts nutritionFacts) {
        this.id = id;
        this.time = time;
        this.diningType = "InDining";
        this.eaten = eaten;
        this.name = name;
        this.serving = serving;
        this.type = type;
        this.nutritionFacts = nutritionFacts;
    }

    public InDining( Map<String,Object> metadata ) {
	
        this.id = (String) metadata.get("Id");
	    this.time = (Time) metadata.get("Time");
        this.diningType = "InDining";
	    this.eaten = (Boolean) metadata.get("Eaten");
        this.name = (String) metadata.get("Name");
        this.serving = (String) metadata.get("Serving");
        this.type = (String) metadata.get("Type");
	  
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setServing(String serving) {
        this.serving = serving;
    }

    public String getServing() {
        return serving;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public NutritionFacts getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(NutritionFacts nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public void setNutritionFacts(String nutString) {
        this.nutritionFacts =  new NutritionFacts(nutString);
    }

    @Override
    public Map<String,Object> getAll() {

	Map<String, Object> all = super.getAll();

	all.put("Name", this.name);
	all.put("Serving", this.serving);
	all.put("Type", this.type);
		
	return all;
    }
    
    @Override
    public String toString() {
        return "InDining{" +
                "name='" + name + '\'' +
                ", serving='" + serving + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", diningType='" + diningType + '\'' +
                '}';
    }

    @Override
    public String toTxtFile() {
        return id + "|" + "InDining" + "|" + time.toTxt() + "|" + eaten + "|" + name + "|" + serving + "|" + type
                + "|" + nutritionFacts.toTxt() + "| | | |";
    }
}
