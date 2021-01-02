
public class Notification {

    private String date;
    private String includings;

    public Notification(String date, String includings){
        this.date = date;
        this.includings = includings;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIncludings() {
        return includings;
    }

    public void setIncludings(String includings) {
        this.includings = includings;
    }
}
