// 추상 클래스 SmartPhone 정의 - 공통 속성과 동작을 추출하여 선언
abstract class SmartPhone {
    String manufacturer; // 제조사 이름
    String model;        // 모델 이름

    // 생성자: 제조사와 모델명을 받아 초기화
    SmartPhone(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    // 전원 켜기 메서드
    void turnOn() {
        System.out.println(model + " 전원 켜짐");
    }

    // 전원 끄기 메서드
    void turnOff() {
        System.out.println(model + " 전원 꺼짐");
    }

    // 음성비서 실행 (구체 동작은 자식 클래스에서 정의)
    abstract void useVoiceAssistant();

    // 앱 실행 메서드 (카카오톡 등 앱 이름 전달)
    abstract void kakaotalk();

    // 메시지 보내기 메서드 (수신자와 메시지 전달)
    abstract void sendMessage(SmartPhone receiver, String message);

    // 메시지 받기 메서드
    void receiveMessage(String sender, String message) {
        System.out.println("[" + model+"유저]"+ "에게서 [" + sender+"유저" + "]에게 메시지 받은내용: " + message);
    }
}

// Galaxy 클래스: SmartPhone 상속받아 구체 구현
class Galaxy extends SmartPhone {
    // 생성자: 모델명을 받아 제조사는 "Samsung"으로 선언
    Galaxy(String model) {
        super("", model);
    }

    // 빅스비 음성비서 실행
    void useVoiceAssistant() {
        System.out.println("Samsung 빅스비 실행");
    }

    // OneUI 런처로 앱 실행
    void kakaotalk() {
        System.out.println("빅스비로 '" + "카카오톡" + "' 앱 실행");
    }

    // 메시지 전송 구현
    void sendMessage(SmartPhone receiver, String message) {
        System.out.println("[Galaxy에서 메시지 전송] '" + model+" USER' 용주가" + " → '" + receiver.model+" USER'"+" 춘자에게 : "+message);
        receiver.receiveMessage(model, message); // 수신자에게 메시지 전달
    }
}

// iPhone 클래스: SmartPhone을 상속받아 구체 구현
class iPhone extends SmartPhone {
    // 생성자: 모델명을 받아 제조사는 "Apple"으로 선언
    iPhone(String model) {
        super("Apple", model);
    }

    // 시리 음성비서 실행
    void useVoiceAssistant() {
        System.out.println("Apple 시리 실행");
    }

    // iOS 홈에서 앱 실행
    void kakaotalk() {
        System.out.println("시리로 '" + "카카오톡" + "' 앱 실행");
    }

    // 메시지 전송 구현
    void sendMessage(SmartPhone receiver, String message) {
        System.out.println("[iMessage에서 메세지 전송] '" + model+" USER' 춘자가" + " → '" + receiver.model+" USER'"+" 용주에게 : "+ message);
        receiver.receiveMessage(model, message); // 수신자에게 메시지 전달
    }
}

// 실행 클래스 (main 메서드 포함)
public class SmartPhoneTest {
    public static void main(String[] args) {
        // Galaxy 객체 생성
        SmartPhone galaxy = new Galaxy("Galaxy S24");
        // iPhone 객체 생성
        SmartPhone iphone = new iPhone("iPhone 15 PRO MAX");



        galaxy.turnOn(); // 스마트폰 전원 켜기
        System.out.println("---------------------------------------------------------------------------------");

        galaxy.useVoiceAssistant(); // 음성비서 실행하기
        galaxy.kakaotalk(); // 카카오톡 앱 실행하기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        galaxy.sendMessage(iphone, "안녕! 지금 뭐해?");  // 메시지 주고받기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        iphone.turnOn(); // 스마트폰 전원 켜기
        System.out.println("---------------------------------------------------------------------------------");
        iphone.useVoiceAssistant(); // 음성비서 실행하기
        iphone.kakaotalk(); // 카카오톡 앱 실행하기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");


        iphone.sendMessage(galaxy, "나는 코딩중이야");  // 메시지 주고받기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        galaxy.sendMessage(iphone, " 아그래? 나도 곧 시작할려고~");  // 메시지 주고받기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        iphone.sendMessage(galaxy, "그래~ 화이팅해!"); // 메시지 주고받기
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        // 두 스마트폰 전원 끄기
        galaxy.turnOff();
        System.out.println("---------------------------------------------------------------------------------");
        iphone.turnOff();

    }
}
