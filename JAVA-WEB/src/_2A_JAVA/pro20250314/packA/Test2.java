package _2A_JAVA.pro20250314.packA;

public class Test2 {
//	public static void say(Dog d) {
//		d.speak();
//	}
//	public static void say(Cat c) {
//		c.speak();
//	}
//	public static void say(Hen h) {
//		h.speak();
//	}
	public static void say(Animal a) {
		a.speak();
	}
	public static void main(String[] args) {
		Animal ani = new Animal();
		Dog dog = new Dog();
		Cat cat = new Cat();
		Hen hen = new Hen();
		say(dog);
		say(ani);
		say(cat);
		say(hen);
	}
}
