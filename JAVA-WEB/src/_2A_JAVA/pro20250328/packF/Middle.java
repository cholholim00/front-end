package _2A_JAVA.pro20250328.packF;

public class Middle extends Primary {
	protected int history;
	public Middle(String name, String schoolName, int korean, int english, int math, int history) {
		super(name,schoolName,korean,english,math);
		this.history = history;
	}
	@Override
	protected int getMeanValue() {
		return (getKorean() + getEnglish() + getMath() + history)/4;
	}
	@Override
	public String getGrade() {
		return getSchoolName() + "중학교를 다니는 " + getName() + " 학생의 학점은 "+ calculate(getMeanValue()) +"입니다!";
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	
}
