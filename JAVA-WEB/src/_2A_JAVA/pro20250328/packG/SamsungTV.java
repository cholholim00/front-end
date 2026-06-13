package _2A_JAVA.pro20250328.packG;

public class SamsungTV implements TV {

	public void operator() {
		System.out.println("삼성TV: 구동한다...");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("삼성TV: 소리 높임...");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성TV: 소리 줄임...");
	}

}
