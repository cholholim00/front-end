package _2A_JAVA.pro20250321.packD;

public class Middle extends Primary {
	protected int history;
	public Middle(String name, String schoolName, int korean, int english, int math, int history) {
		super(name,schoolName,korean,english,math);
		this.history = history;
	}
	public String getGrade() {
		int mean_value = (korean + english + math + history) / 4;
		String result = "";
		if (mean_value >= 90) {
			result = schoolName + "중학교를 다니는 " + name + " 학생의 학점은 A입니다!";
		}else if (mean_value >= 80) {
			result = schoolName + "중학교를 다니는 " + name + " 학생의 학점은 B입니다!";
		}else if (mean_value >= 70) {
			result = schoolName + "중학교를 다니는 " + name + " 학생의 학점은 C입니다!";
		}else if (mean_value >= 60) {
			result = schoolName + "중학교를 다니는 " + name + " 학생의 학점은 D입니다!";
		}else {
			result = schoolName + "중학교를 다니는 " + name + " 학생의 학점은 F입니다!";
		}
		return result;
	}
}
