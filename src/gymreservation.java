import java.sql.Time;

public class gymreservation {
    int num;
    Time startTime,endTime;
    public gymreservation(int num,Time startTime,Time endTime){
        this.num=num;
        this.endTime=endTime;
        this.startTime=startTime;
    }

    public int getNum() {
        return num;
    }

    public Time getEndTime() {
        return endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
}
