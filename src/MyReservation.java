public class MyReservation {
    private String number;
    private String date;
    private String time;
    public MyReservation(String number,String date,String time){
        this.date=date;
        this.number=number;
        this.time=time;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
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
