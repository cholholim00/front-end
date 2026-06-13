package _2A_JAVA.pro20250321.packF;

abstract public class Student {
	private String name;
	private String schoolName;
	
	public Student(String name, String schoolName) {
		this.name = name;
		this.schoolName = schoolName;
	}
	
	protected String calculate(int mean_value) {
		if (mean_value >= 90) {
			return "A";
		}else if (mean_value >= 80) {
			return "B";
		}else if (mean_value >= 70) {
			return "C";
		}else if (mean_value >= 60) {
			return "D";
		}else {
			return "F";
		}
	}
	abstract protected int getMeanValue();
	abstract public String getGrade();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
