package _2A_JAVA.pro20250328.packF;

public class High extends Middle{
	private int computer;
	public High(String name, String schoolName, int korean, int english, int math, int history, int computer) {
		super(name, schoolName, korean, english, math, history);
		this.computer = computer;
	}
	@Override
	protected int getMeanValue() {
		return (getKorean() + getEnglish() + getMath() + getHistory() + computer)/5;
	}
	@Override
	public String getGrade() {
		return getSchoolName() + "고등학교를 다니는 " + getName() + " 학생의 학점은 "+ calculate(getMeanValue()) +"입니다!";
	}
	public int getComputer() {
		return computer;
	}
	public void setComputer(int computer) {
		this.computer = computer;
	}
}
