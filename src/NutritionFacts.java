public class NutritionFacts {
    int calories;
    int fat;
    int carbohydrate;
    int protein;
    int cholesterol;
    int sodium;

    public NutritionFacts(int calories, int fat, int carbohydrate, int protein, int cholesterol, int sodium){
        this.calories = calories;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
    }

    public NutritionFacts(String nutString) {
        String[] vals = nutString.split(",");
        this.setCalories(Integer.valueOf(vals[0]));
        this.setFat(Integer.valueOf(vals[1]));
        this.setCarbohydrate(Integer.valueOf(vals[2]));
        this.setProtein(Integer.valueOf(vals[3]));
        this.setCholesterol(Integer.valueOf(vals[4]));
        this.setSodium(Integer.valueOf(vals[5]));
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public String toTxtFile() {
        return calories + " Calories," + fat + " Fat, " + carbohydrate + " Carbohydrate," + protein + " Protein, "
                + cholesterol + " Cholesterol, " + sodium + " Sodium";
    }

    public String toTxt() {
        return calories + "," + fat + "," + carbohydrate + "," + protein + "," + cholesterol + "," + sodium;
    }
}
