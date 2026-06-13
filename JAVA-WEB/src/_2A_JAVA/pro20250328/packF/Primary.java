package _2A_JAVA.pro20250328.packF;

public class Primary extends Student{
	private int korean, english, math;
	public Primary(String name, String schoolName, int korean, int english, int math) {
		super(name, schoolName);
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	@Override
	protected int getMeanValue() {
		return (korean + english + math)/3;
	}
	@Override
	public String getGrade() {
		return getSchoolName() + "초등학교를 다니는 " + getName() + " 학생의 학점은 "+ calculate(getMeanValue()) +"입니다!";
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
