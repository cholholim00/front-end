package _2A_JAVA.pro2024201019.최호림;

import java.util.Random;

public class AutoSimulation {
    public static void main(String[] args) {
        Random random = new Random();

        // 스피커 객체 생성
        Speaker BSpeaker = new Speaker("보스");
        Speaker SSpeaker = new Speaker("소니");
        Speaker ISpeaker = new Speaker("인켈");


        // 자동차와 텔레비전 객체 생성
        Car Hcar = new Car("현대");
        Car Kcar = new Car("기아");

        Television Stv = new Television("삼성", new Speaker("삼성 스피커"));
        Television Ltv = new Television("LG", new Speaker("LG 스피커"));

        // 랜덤 동작 시뮬레이션
        for (int i = 0; i < 10; i++) { // 10번 반복
            int choice = random.nextInt(3); // 0: 자동차, 1: 텔레비전, 2: 스피커

            if (choice == 0) { // 자동차 동작
                int carAction = random.nextInt(10); // 0~9
                switch (carAction) {
                    case 0 -> Hcar.startEngine();
                    case 1 -> Hcar.stopEngine();
                    case 2 -> Hcar.moveForward();
                    case 3 -> Hcar.moveBackward();
                    case 4 -> Hcar.stop();
                    case 5 -> Kcar.startEngine();
                    case 6 -> Kcar.stopEngine();
                    case 7 -> Kcar.moveForward();
                    case 8 -> Kcar.moveBackward();
                    case 9 -> Kcar.stop();
                    default -> System.out.println("잘못된 동작입니다.");
                }
            } else if (choice == 1) { // 텔레비전 동작
                int tvAction = random.nextInt(8); // 0~8
                switch (tvAction) {
                    case 0 -> Stv.turnOn();
                    case 1 -> Stv.turnOff();
                    case 2 -> Stv.watchMovie();
                    case 3 -> Stv.watchDrama();
                    case 4 -> Ltv.turnOn();
                    case 5 -> Ltv.turnOff();
                    case 6 -> Ltv.watchMovie();
                    case 7 -> Ltv.watchDrama();
                    default -> System.out.println("잘못된 동작입니다.");
                }
            } else { // 스피커 동작
                int speakerAction = random.nextInt(5); // 0~5
                switch (speakerAction) {
                    case 0 -> BSpeaker.turnOn();
                    case 1 -> BSpeaker.turnOff();
                    case 2 -> SSpeaker.turnOn();
                    case 3 -> SSpeaker.turnOff();
                    case 4 -> ISpeaker.turnOn();
                    case 5 -> ISpeaker.turnOff();
                    default -> System.out.println("잘못된 동작입니다.");
                }
            }
        }

        // 최종 상태 출력
        System.out.println("\n최종 상태:");
        // 자동차 상태 출력
        Hcar.showStatus();
        Kcar.showStatus();
        // 텔레비전 상태 출력
        Stv.showStatus();
        Ltv.showStatus();
        // 스피커 상태 출력
        BSpeaker.showStatus();
        SSpeaker.showStatus();
        ISpeaker.showStatus();
    }
}
