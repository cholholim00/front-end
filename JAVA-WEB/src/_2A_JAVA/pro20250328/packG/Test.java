package _2A_JAVA.pro20250328.packG;

public class Test {

	public static void main(String[] args) {
		TV tv = new SamsungTV();
		tv.volumeUp();
		tv.volumeDown();
		tv = new LgTV();
		tv.volumeUp();
		tv.volumeDown();
		
		LgTV lg = (LgTV)tv;
		lg.run();
	}
}
