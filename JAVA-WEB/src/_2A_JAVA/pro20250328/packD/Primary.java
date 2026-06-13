package _2A_JAVA.pro20250328.packD;

public class Primary extends Student{
	protected int korean, english, math;
	public Primary(String name, String schoolName, int korean, int english, int math) {
		//this.name = name;
		//this.schoolName = schoolName;
		super(name, schoolName);
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	public String getGrade() {
		int mean_value = (korean + english + math) / 3;
		String result = "";
		if (mean_value >= 90) {
			result = schoolName + "초등학교를 다니는 " + name + " 학생의 학점은 A입니다!";
		}else if (mean_value >= 80) {
			result = schoolName + "초등학교를 다니는 " + name + " 학생의 학점은 B입니다!";
		}else if (mean_value >= 70) {
			result = schoolName + "초등학교를 다니는 " + name + " 학생의 학점은 C입니다!";
		}else if (mean_value >= 60) {
			result = schoolName + "초등학교를 다니는 " + name + " 학생의 학점은 D입니다!";
		}else {
			result = schoolName + "초등학교를 다니는 " + name + " 학생의 학점은 F입니다!";
		}
		return result;
	}
}
