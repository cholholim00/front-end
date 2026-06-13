package _2A_JAVA.pro20250411;

public class Student {
	private String hakbun;
	private String name;
	private String schoolName;
	private String gender;
	private int age;
	public Student(String hakbun, String name, String schoolname, String gender, int age) {
		this.hakbun = hakbun;
		this.name = name;
		this.schoolName = schoolname;
		this.gender = gender;
		this.age = age;
	}	
	@Override
	public String toString() {
		return "학번:"+hakbun+", 이름:"+name+", 학교명:"+schoolName+", 성별:"+gender+", 나이:"+age;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
