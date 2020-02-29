import java.util.HashMap;
import java.util.Map;

public class InDining extends FoodItem {
    String name;
    String serving;
    String type;

    public InDining(){}

    public InDining(String id, String time, String name, String serving, String type) {
        this.id = id;
        this.time = time;
        this.diningType = "Indining";
        this.name = name;
        this.serving = serving;
        this.type = type;
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

    @Override
    public Map<String,String> getAll() {

	Map<String, String> all = super.getAll();

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
        return id + "|" + "InDining" + "|" + time + "|" + name + "|" + serving + "|" + type + "| | | ";
    }
}
