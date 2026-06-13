package _2A_JAVA.pro20250328.packF;

public class Test {

	public static void main(String[] args) {
		/*
		Student student = new Middle("홍길동","강서",70,80,90,100);
		System.out.println(student.getGrade());
		student = new Primary("홍길순","강동",80,90,100);
		System.out.println(student.getGrade());
		student = new High("김국진","강서",70,80,90,100,80);
		System.out.println(student.getGrade());
		*/
		Student [] students = {
				new Middle("홍길동","강서",70,80,90,100),
				new Primary("홍길순","강동",80,90,100),
				new High("김국진","강서",70,80,90,100,80)
		};
		for(Student s : students) {
			System.out.println(s.getGrade());
		}
	}

}
