package _2A_JAVA.pro2024201019.최호림;

public class Car {
    private String brand;
    private boolean engineOn;

    public Car(String brand) {
        this.brand = brand;
        this.engineOn = false;
    }

    public void startEngine() {
        engineOn = true;
        System.out.println(brand + " 자동차의 엔진이 켜졌습니다.");
    }

    public void stopEngine() {
        engineOn = false;
        System.out.println(brand + " 자동차의 엔진이 꺼졌습니다.");
    }

    public void moveForward() {
        if (engineOn) {
            System.out.println(brand + " 자동차가 앞으로 이동합니다.");
        } else {
            System.out.println(brand + " 자동차의 엔진이 꺼져 있어 이동할 수 없습니다.");
        }
    }

    public void moveBackward() {
        if (engineOn) {
            System.out.println(brand + " 자동차가 뒤로 이동합니다.");
        } else {
            System.out.println(brand + " 자동차의 엔진이 꺼져 있어 이동할 수 없습니다.");
        }
    }

    public void stop() {
        System.out.println(brand + " 자동차가 멈췄습니다.");
    }

    public void showStatus() {
        System.out.println(brand + " 자동차 상태: 엔진 " + (engineOn ? "켜짐" : "꺼짐"));
    }
}
