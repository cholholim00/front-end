package _2A_JAVA.pro20250328.packG;

public class LgTV implements TV {

	public void run() {
		System.out.println("엘지TV: 동작한다...");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("엘지TV: 소리 높임...");
	}

	@Override
	public void volumeDown() {
		System.out.println("엘지TV: 소리 줄임...");
	}

}
