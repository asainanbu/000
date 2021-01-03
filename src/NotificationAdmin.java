import java.sql.Date;

public class NotificationAdmin {

    private Date date;
    private String content;

    public NotificationAdmin(Date date, String content){
        this.date = date;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
