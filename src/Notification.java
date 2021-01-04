import java.sql.Date;

public class Notification {

    private Date date;
    private String includings;

    public Notification(Date date, String includings){
        this.date = date;
        this.includings = includings;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIncludings() {
        return includings;
    }

    public void setIncludings(String includings) {
        this.includings = includings;
    }
}
