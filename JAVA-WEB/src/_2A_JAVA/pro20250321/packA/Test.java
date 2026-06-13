package _2A_JAVA.pro20250321.packA;

public class Test {
	public static void speak(Animal ani) {
		ani.say();
	}
	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();
		speak(d);
		speak(c);
	}

}
