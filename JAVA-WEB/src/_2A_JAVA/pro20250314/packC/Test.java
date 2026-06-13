package _2A_JAVA.pro20250314.packC;

public class Test {
	public static void works(Person p) {
		p.work();
	}
	public static void main(String[] args) {
		Student s = new Student();
		Worker w = new Worker();
		Teacher t = new Teacher();
		works(s);
		works(w);
		works(t);
	}

}
