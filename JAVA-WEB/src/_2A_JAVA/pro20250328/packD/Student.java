package _2A_JAVA.pro20250328.packD;

abstract public class Student {
	protected String name;
	protected String schoolName;
	public Student(String name, String schoolName) {
		this.name = name;
		this.schoolName = schoolName;
	}
	abstract public String getGrade();
}
