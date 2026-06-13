package _2A_JAVA.pro20250328.packE;

public class Middle extends Primary {
	protected int history;
	public Middle(String name, String schoolName, int korean, int english, int math, int history) {
		super(name,schoolName,korean,english,math);
		this.history = history;
	}
	public String getGrade() {
		int mean_value = (getKorean() + getEnglish() + getMath() + history) / 4;
		String result = "";
		if (mean_value >= 90) {
			result = getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 A입니다!";
		}else if (mean_value >= 80) {
			result = getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 B입니다!";
		}else if (mean_value >= 70) {
			result = getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 C입니다!";
		}else if (mean_value >= 60) {
			result = getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 D입니다!";
		}else {
			result = getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 F입니다!";
		}
		return result;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	
}
