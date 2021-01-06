import java.sql.Date;

public class MyReservation {
    private int number;
    private Date date;
    private String time;

    public MyReservation(int number, Date date, String time) {
        this.date = date;
        this.number = number;
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
