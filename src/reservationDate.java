import java.sql.Date;
public class reservationDate {
    private Date date;
    public reservationDate(Date date){
        this.date=date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
