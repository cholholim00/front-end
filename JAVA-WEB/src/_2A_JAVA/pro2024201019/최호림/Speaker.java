package _2A_JAVA.pro2024201019.최호림;

public class Speaker {
    private String brand;
    private boolean isOn;

    public Speaker(String brand) {
        this.brand = brand;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " 스피커가 켜졌습니다.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " 스피커가 꺼졌습니다.");
    }

    public void showStatus() {
        System.out.println(brand + " 스피커 상태: " + (isOn ? "켜짐" : "꺼짐"));
    }
}
