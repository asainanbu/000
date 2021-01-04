import java.sql.Date;

public class MyReservation {
    private String number;
    private Date date;
    private String time;
    public MyReservation(String number,Date date,String time){
        this.date=date;
        this.number=number;
        this.time=time;
    }

    public Date getdate() {
        return date;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    public String getnumber() {
        return number;
    }

    public void setumber(String number) {
        this.number=number;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }
}
