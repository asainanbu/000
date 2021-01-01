public class NotificationResource {
private String date;
private String includings;
public NotificationResource(String date,String includings){
    this.date=date;
    this.includings=includings;
}
    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getincludings() {
        return includings;
    }

    public void setincludings(String includings) {
        this.includings = includings;
    }
}
