package _2A_JAVA.pro20250328.packE;

public class Primary extends Student{
	private int korean, english, math;
	public Primary(String name, String schoolName, int korean, int english, int math) {
		super(name, schoolName);
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	public String getGrade() {
		int mean_value = (korean + english + math) / 3;
		String result = "";
		if (mean_value >= 90) {
			result = getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 A입니다!";
		}else if (mean_value >= 80) {
			result = getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 B입니다!";
		}else if (mean_value >= 70) {
			result = getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 C입니다!";
		}else if (mean_value >= 60) {
			result = getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 D입니다!";
		}else {
			result = getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 F입니다!";
		}
		return result;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}
