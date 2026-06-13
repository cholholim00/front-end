package _2A_JAVA.pro20250314.packA;

public class Test {
	public static void say(Dog d) {
		d.speak();
	}
	public static void say(Cat c) {
		c.speak();
	}
	public static void say(Hen h) {
		h.speak();
	}
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Hen hen = new Hen();
//		dog.speak();
//		cat.speak();
//		hen.speak();
		say(dog);
		say(cat);
		say(hen);
	}
}
