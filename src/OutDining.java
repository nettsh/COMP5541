public class OutDining extends FoodItem {
    String retailer;
    String meal;
    String group;

    public OutDining(){}

    public OutDining(String id, String time, String retailer, String meal, String group) {
        this.id = id;
        this.time = time;
        this.retailer = retailer;
        this.meal = meal;
        this.group = group;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getRetailer() {
        return retailer;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getMeal() {
        return meal;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public Boolean getExistence(String attribute) {

	return false;
    }
    
    @Override
    public String toString() {
        return "OutDining{" +
                "retailer='" + retailer + '\'' +
                ", meal='" + meal + '\'' +
                ", group='" + group + '\'' +
                ", time='" + time + '\'' +
                ", id='" + id + '\'' +
                ", diningType='" + diningType + '\'' +
                '}';
    }

    @Override
    public String toTxtFile() {
        //2|OutDining|JAN 31| | | |AW|Frites|Fat
        return id + "|" + "OutDining" + "|" + time + "| | | |" + retailer + "|" + meal + "|" + group;
    }
}
