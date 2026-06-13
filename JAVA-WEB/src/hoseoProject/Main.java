package hoseoProject;

import java.util.Scanner;

// Device 추상 클래스는 공통 기능(브랜드, 전원, 볼륨 등)을 정의하고
// 이를 상속받는 하위 클래스(Speaker, TV)가 실제 동작을 구현하도록 구성됨
abstract class Device {
    // 기기의 브랜드명을 저장하는 필드
    protected String brand;

    // 전원이 켜져 있는지 여부를 저장하는 필드 (true = 켜짐, false = 꺼짐)
    protected boolean isOn;

    // 현재 볼륨 수치를 저장하는 필드
    protected int volume;

    // 최소 볼륨 수치
    protected int minVolume;

    // 최대 볼륨 수치
    protected int maxVolume;

    // 기기 생성 시 브랜드, 기본 볼륨, 최소/최대 볼륨 설정 및 전원을 꺼진 상태로 초기화
    public Device(String brand, int defaultVolume, int minVolume, int maxVolume) {
        this.brand = brand; // 브랜드 이름 초기화
        this.volume = defaultVolume; // 기본 볼륨 초기화
        this.minVolume = minVolume; // 최소 볼륨 초기화
        this.maxVolume = maxVolume; // 최대 볼륨 초기화
        this.isOn = false; // 초기 상태는 꺼짐
    }

    // 전원 상태를 토글하는 메소드: 꺼져 있으면 켜고, 켜져 있으면 끔
    public void togglePower() {
        // 전원 상태를 반전시킴. 켜져 있으면 끄고, 꺼져 있으면 켬
        isOn = !isOn; // 전원 상태를 반전
        // 현재 전원 상태에 따라 메시지를 출력
        System.out.println("[" + brand + "] 전원이 " + (isOn ? "켜짐" : "꺼짐")); // 현재 전원 상태 출력
        // 현재 상태(브랜드, 전원 여부, 볼륨 등)를 출력하는 추상 메소드 호출
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // 볼륨을 1 증가시키는 메소드 (단, 전원이 켜져 있어야 함)
    public void increaseVolume() {
        // 전원이 꺼져 있으면 볼륨 조작 불가
        if (!isOn) { // 전원이 꺼져 있는 경우
            System.out.println("[" + brand + "] 전원이 꺼져 있어 볼륨 조절 불가"); // 경고 메시지 출력
            return; // 메소드 종료
        }
        // 현재 볼륨이 최대 볼륨보다 작으면 증가시킬 수 있음
        if (volume < maxVolume) { // 현재 볼륨이 최대 볼륨보다 낮은 경우
            // 볼륨을 1 증가시킴
            volume++; // 볼륨 증가
            System.out.println("[" + brand + "] 볼륨 증가 → " + volume); // 증가된 볼륨 출력
        } else {
            System.out.println("[" + brand + "] 이미 최대 볼륨(" + maxVolume + ")입니다."); // 최대 볼륨 도달 경고
        }
        // 변경된 상태를 출력
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // 볼륨을 1 감소시키는 메소드 (단, 전원이 켜져 있어야 함)
    public void decreaseVolume() {
        // 전원이 꺼져 있으면 볼륨 조작 불가
        if (!isOn) { // 전원이 꺼져 있는 경우
            System.out.println("[" + brand + "] 전원이 꺼져 있어 볼륨 조절 불가"); // 경고 메시지 출력
            return; // 메소드 종료
        }
        // 현재 볼륨이 최소 볼륨보다 높은 경우
        if (volume > minVolume) { // 현재 볼륨이 최소 볼륨보다 높은 경우
            // 볼륨을 1 감소시킴
            volume--; // 볼륨 감소
            System.out.println("[" + brand + "] 볼륨 감소 → " + volume); // 감소된 볼륨 출력
        } else {
            System.out.println("[" + brand + "] 이미 최소 볼륨(" + minVolume + ")입니다."); // 최소 볼륨 도달 경고
        }
        // 변경된 상태를 출력
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // 기기의 현재 상태를 표시하는 메소드 (하위 클래스에서 구현 필수)
    public abstract void displayStatus(); // 상태를 표시하는 메소드의 추상 정의
}

// 스피커 기기를 나타내는 클래스, Device를 상속받아 구현
class Speaker extends Device {

    // Speaker 클래스의 생성자. 브랜드, 기본 볼륨, 최소 및 최대 볼륨을 초기화
    public Speaker(String brand, int defaultVolume, int minVolume, int maxVolume) {
        super(brand, defaultVolume, minVolume, maxVolume); // 상위 클래스의 생성자 호출
    }

    // 스피커의 전원 및 볼륨 상태를 콘솔에 출력
    @Override
    public void displayStatus() {
        System.out.println("현재 [" + brand + " 스피커] 상태: 전원(" + (isOn ? "켜짐" : "꺼짐") + "), 볼륨 " + volume); // 상태 출력
        System.out.println(); // 줄 바꿈
    }
}

// TV 기기를 나타내는 클래스, Device를 상속받아 채널/모드 기능을 추가로 구현
class TV extends Device {
    // 현재 채널 번호를 저장
    private int channel;

    // 현재 시청 모드("일반", "넷플릭스", "디즈니")를 저장
    private String mode;  // "일반", "넷플릭스", "디즈니" 등

    // TV 생성 시 기본 볼륨/채널/모드를 설정
    public TV(String brand, int defaultVolume, int minVolume, int maxVolume) {
        super(brand, defaultVolume, minVolume, maxVolume); // 상위 클래스의 생성자 호출
        this.channel = 1; // 기본 채널을 1로 설정
        this.mode = "일반"; // 기본 모드를 "일반"으로 설정
    }

    // 채널을 1 증가시키는 메소드 (전원 켜져 있어야 함)
    public void channelUp() {
        // 전원이 꺼져 있으면 채널 조작 불가
        if (!isOn) { // 전원이 꺼져 있는 경우
            System.out.println("[" + brand + " TV] 전원이 꺼져 있어 채널 조절 불가"); // 경고 메시지 출력
            return; // 메소드 종료
        }
        // 채널을 1 증가시킴
        channel++; // 채널 증가
        System.out.println("[" + brand + " TV] 채널 증가 → " + channel); // 증가된 채널 출력
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // 채널을 1 감소시키는 메소드 (전원 켜져 있어야 함)
    public void channelDown() {
        // 전원이 꺼져 있으면 채널 조작 불가
        if (!isOn) { // 전원이 꺼져 있는 경우
            System.out.println("[" + brand + " TV] 전원이 꺼져 있어 채널 조절 불가"); // 경고 메시지 출력
            return; // 메소드 종료
        }
        // 현재 채널이 1보다 큰 경우
        if (channel > 1) { // 현재 채널이 1보다 큰 경우
            // 채널을 1 감소시킴
            channel--; // 채널 감소
            System.out.println("[" + brand + " TV] 채널 감소 → " + channel); // 감소된 채널 출력
        } else {
            System.out.println("[" + brand + " TV] 채널은 1보다 작을 수 없습니다."); // 채널 최소 경고
        }
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // 시청 모드를 변경하는 메소드 (지원 모드인지 확인 필요)
    public void setMode(String mode) {
        // 전원이 꺼져 있으면 모드 변경 불가
        if (!isOn) { // 전원이 꺼져 있는 경우
            System.out.println("[" + brand + " TV] 전원이 꺼져 있어 시청 모드 변경 불가"); // 경고 메시지 출력
            return; // 메소드 종료
        }
        // 지원하는 모드인지 확인
        if (mode.equals("U+TV") || mode.equals("넷플릭스") || mode.equals("디즈니")) {
            this.mode = mode; // 모드 변경
            System.out.println("[" + brand + " TV] 시청 모드 변경 → " + mode); // 변경된 모드 출력
        } else {
            System.out.println("[" + brand + " TV] 지원하지 않는 모드입니다."); // 지원하지 않는 모드 경고
        }
        displayStatus(); // 현재 상태를 표시하는 메소드 호출
    }

    // TV의 전원/볼륨/채널/모드 상태를 콘솔에 출력
    @Override
    public void displayStatus() {
        System.out.println("현재 [" + brand + " TV] 상태: 전원(" + (isOn ? "켜짐" : "꺼짐")
                + "), 볼륨 " + volume + ", 채널 " + channel + ", 모드 " + mode); // 상태 출력
        System.out.println(); // 줄 바꿈
    }
}

// 프로그램 실행 시작 클래스. 사용자와 상호작용하며 기기 제어 메뉴 제공
public class Main {

    // 메인 메소드: 사용자 입력을 통해 기기 선택 및 제어 메뉴 실행
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 객체 생성
        Speaker sonySpeaker = new Speaker("소니", 25, 0, 100); // 소니 스피커 객체 생성
        Speaker marshallSpeaker = new Speaker("마샬", 28, 0, 100); // 마샬 스피커 객체 생성
        TV samsungTV = new TV("삼성", 26, 0, 100); // 삼성 TV 객체 생성
        TV lgTV = new TV("엘지", 29, 0, 100); // 엘지 TV 객체 생성

        boolean running = true; // 프로그램 실행 상태를 나타내는 변수
        while (running) {
            System.out.println("----- 기기 타입 선택 메뉴 -----");
            System.out.println("1. 스피커 제어 진입");
            System.out.println("2. TV 제어 진입");
            System.out.println("3. 종료");
            System.out.print("선택: ");
            int typeChoice = scanner.nextInt(); // 사용자 입력 받기

            switch (typeChoice) {
                case 1: // Speaker 선택
                    boolean speakerMenu = true; // 스피커 메뉴 상태 변수
                    while (speakerMenu) {
                        System.out.println("----- 스피커 선택 메뉴 -----");
                        System.out.println("1. 소니 스피커");
                        System.out.println("2. 마샬 스피커");
                        System.out.println("3. 이전 메뉴로 돌아가기");
                        System.out.print("선택: ");
                        int speakerChoice = scanner.nextInt(); // 사용자 입력 받기
                        switch (speakerChoice) {
                            case 1:
                                controlSpeaker(scanner, sonySpeaker); // 소니 스피커 제어
                                break;
                            case 2:
                                controlSpeaker(scanner, marshallSpeaker); // 마샬 스피커 제어
                                break;
                            case 3:
                                speakerMenu = false; // 이전 메뉴로 돌아가기
                                break;
                            default:
                                System.out.println("잘못된 접근입니다."); // 잘못된 선택 경고
                                break;
                        }
                    }
                    break;
                case 2: // TV 선택
                    boolean tvMenu = true; // TV 메뉴 상태 변수
                    while (tvMenu) {
                        System.out.println("----- TV 선택 메뉴 -----");
                        System.out.println("1. 삼성 TV");
                        System.out.println("2. 엘지 TV");
                        System.out.println("3. 이전 메뉴로 돌아가기");
                        System.out.print("선택: ");
                        int tvChoice = scanner.nextInt(); // 사용자 입력 받기
                        scanner.nextLine(); // 개행 문자 제거
                        switch (tvChoice) {
                            case 1:
                                controlTV(scanner, samsungTV); // 삼성 TV 제어
                                break;
                            case 2:
                                controlTV(scanner, lgTV); // 엘지 TV 제어
                                break;
                            case 3:
                                tvMenu = false; // 이전 메뉴로 돌아가기
                                break;
                            default:
                                System.out.println("잘못된 접근입니다."); // 잘못된 선택 경고
                                break;
                        }
                    }
                    break;
                case 3:
                    running = false; // 프로그램 종료
                    System.out.println("프로그램을 종료합니다."); // 종료 메시지 출력
                    break;
                default:
                    System.out.println("잘못된 접근입니다."); // 잘못된 선택 경고
                    break;
            }
        }
        scanner.close(); // 스캐너 닫기
    }

    // 스피커 기기 조작을 위한 제어 메뉴 제공 메소드
    public static void controlSpeaker(Scanner scanner, Speaker speaker) {
        boolean back = false; // 이전 메뉴로 돌아가기 상태 변수
        while (!back) {
            System.out.println("[" + speaker.brand + " 스피커] 제어 메뉴:");
            System.out.println("1. 전원 토글");
            System.out.println("2. 볼륨 높이기");
            System.out.println("3. 볼륨 낮추기");
            System.out.println("4. 이전 메뉴로 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt(); // 사용자 입력 받기
            switch (choice) {
                case 1:
                    speaker.togglePower(); // 전원 토글
                    break;
                case 2:
                    speaker.increaseVolume(); // 볼륨 높이기
                    break;
                case 3:
                    speaker.decreaseVolume(); // 볼륨 낮추기
                    break;
                case 4:
                    back = true; // 이전 메뉴로 돌아가기
                    break;
                default:
                    System.out.println("잘못된 접근입니다."); // 잘못된 선택 경고
                    break;
            }
        }
    }

    // TV 기기 조작을 위한 제어 메뉴 제공 메소드
    public static void controlTV(Scanner scanner, TV tv) {
        boolean back = false; // 이전 메뉴로 돌아가기 상태 변수
        while (!back) {
            System.out.println("[" + tv.brand + " TV] 제어 메뉴:");
            System.out.println("1. 전원 토글");
            System.out.println("2. 볼륨 높이기");
            System.out.println("3. 볼륨 낮추기");
            System.out.println("4. 채널 올리기");
            System.out.println("5. 채널 내리기");
            System.out.println("6. 시청 모드 변경 (일반, 넷플릭스, 디즈니)");
            System.out.println("7. 이전 메뉴로 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt(); // 사용자 입력 받기
            scanner.nextLine();  // 개행 문자 제거
            switch (choice) {
                case 1:
                    tv.togglePower(); // 전원 토글
                    break;
                case 2:
                    tv.increaseVolume(); // 볼륨 높이기
                    break;
                case 3:
                    tv.decreaseVolume(); // 볼륨 낮추기
                    break;
                case 4:
                    tv.channelUp(); // 채널 올리기
                    break;
                case 5:
                    tv.channelDown(); // 채널 내리기
                    break;
                case 6:
                    System.out.print("변경할 모드 입력 (U+TV, 넷플릭스, 디즈니): ");
                    String mode = scanner.nextLine(); // 사용자로부터 모드 입력 받기
                    tv.setMode(mode); // 시청 모드 변경
                    break;
                case 7:
                    back = true; // 이전 메뉴로 돌아가기
                    break;
                default:
                    System.out.println("잘못된 접근입니다."); // 잘못된 선택 경고
                    break;
            }
        }
    }
}
