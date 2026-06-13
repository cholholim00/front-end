package _2A_JAVA.pro20250321.packE;

public class High extends Middle{
	private int computer;
	public High(String name, String schoolName, int korean, int english, int math, int history, int computer) {
		super(name, schoolName, korean, english, math, history);
		this.computer = computer;
	}
	public String getGrade() {
		int mean_value = (getKorean() + getEnglish() + getMath() + getHistory() + computer) / 5;
		String result = "";
		if (mean_value >= 90) {
			result = getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 A입니다!";
		}else if (mean_value >= 80) {
			result = getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 B입니다!";
		}else if (mean_value >= 70) {
			result = getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 C입니다!";
		}else if (mean_value >= 60) {
			result = getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 D입니다!";
		}else {
			result = getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 F입니다!";
		}
		return result;
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
}
