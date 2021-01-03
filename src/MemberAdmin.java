import java.util.Objects;

public class MemberAdmin {

	private String username, trueName, status;

	public MemberAdmin(String username, String trueName, String status) {
		this.username = username;
		this.trueName = trueName;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getStatus() {
		if (Objects.equals(this.status, "enabled")) {
			return "已启用";
		}
		else if (Objects.equals(this.status, "disabled")) {
			return "已禁用";
		}
		else if (Objects.equals(this.status, "pending")) {
			return "待审核";
		}
		else {
			return "";
		}
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
