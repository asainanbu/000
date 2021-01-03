import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class ReservationAdmin {

	private int gymNum;
	private Date date;
	private Time time;
	private String status;
	private String memberName;

	public ReservationAdmin(int gymNum, Date date, Time time, String status, String memberName) {
		this.gymNum = gymNum;
		this.date = date;
		this.time = time;
		this.status = status;
		this.memberName = memberName;
	}

	public int getGymNum() {
		return gymNum;
	}

	public void setGymNum(int gymNum) {
		this.gymNum = gymNum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return String.format("%02d:00-%02d:00", time.getHours(), time.getHours() + 1);
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getStatus() {
		if (Objects.equals(status, "available")) {
			return "可预约";
		}
		else if (Objects.equals(status, "pending")) {
			return "待审核";
		}
		else if (Objects.equals(status, "reserved")) {
			return "已预约";
		}
		else if (Objects.equals(status, "disabled")) {
			return "已禁用";
		}
		else {
			return "";
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}
