package _2A_JAVA.pro20250321.packB;

public class Test {

	public static void sound(Things th) {
		th.speak();
	}
	public static void main(String[] args) {
		Car car = new Car();
		Dog dog = new Dog();
		sound(car);
		sound(dog);
	}

}
