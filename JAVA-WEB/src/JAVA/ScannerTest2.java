package JAVA;

import java.util.Scanner;

public class ScannerTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //입력받을 스캐너(입력값) 생성

        System.out.print("나이 : ");
        int age = sc.nextInt(); //입력받은 숫자를 age에 저장

    // 키보드 버퍼를 비운다
        sc.nextLine();

        System.out.print("이름 : ");
        String name = sc.nextLine(); // 입력받은 문자열을 name에 저장

        System.out.println(name + "님은 "+ age + "살 입니다."); //출력
        sc.close();
    }
}
