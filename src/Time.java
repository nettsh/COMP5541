public class Time {
    String day;
    String date;
    String time;

    public Time (String day, String date, String time) {
        this.day = day;
        this.date = date;
        this.time = time;
    }

    public Time(String timeString) {
        String[] vals = timeString.split(",");
        this.setDay(vals[0]);
        this.setDate(vals[1]);
        this.setTime(vals[2]);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toTxt() {
        return day + "," + date + "," + time;
    }
}
