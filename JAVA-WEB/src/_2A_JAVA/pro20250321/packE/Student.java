package _2A_JAVA.pro20250321.packE;

abstract public class Student {
	private String name;
	private String schoolName;
	
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
	public Student(String name, String schoolName) {
		this.name = name;
		this.schoolName = schoolName;
	}
	abstract public String getGrade();
}
