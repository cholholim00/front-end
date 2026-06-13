package _2A_JAVA.pro20250314.packC;

public class Worker extends Person {
	public void work() {
		System.out.println("열심히 일한다!");
	}
	
	public static void main(String args[]) {
		Worker w = new Worker();
		w.work();
	}
}
