package _2A_JAVA.pro2024201019.최호림;

public class Television {
    private String brand;
    private Speaker speaker;
    private boolean isOn;

    public Television(String brand, Speaker speaker) {
        this.brand = brand;
        this.speaker = speaker;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(brand + " 텔레비전이 켜졌습니다.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(brand + " 텔레비전이 꺼졌습니다.");
    }

    public void watchMovie() {
        if (isOn) {
            System.out.println(brand + " 텔레비전에서 영화를 시청합니다.");
        } else {
            System.out.println(brand + " 텔레비전이 꺼져 있어 영화를 시청할 수 없습니다.");
        }
    }

    public void watchDrama() {
        if (isOn) {
            System.out.println(brand + " 텔레비전에서 드라마를 시청합니다.");
        } else {
            System.out.println(brand + " 텔레비전이 꺼져 있어 드라마를 시청할 수 없습니다.");
        }
    }

    public void showStatus() {
        System.out.println(brand + " 텔레비전 상태: " + (isOn ? "켜짐" : "꺼짐"));
    }
}
