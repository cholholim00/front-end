package JAVA;

import java.util.Scanner;

public class StingTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //입력받는 scanner 객체 생성

        System.out.print("문자열 입력 : ");
        String str = sc.nextLine(); //입력받은 한줄을 str문자열에 저장

// length() : 문자열의 문자 개수를 센다.
        System.out.println("글자수 : " + str.length());

//trim() : 문자열 앞, 뒤의 불필요한 빈 칸을 제거한다.
        System.out.println("불필요한 빈 칸을 제거한 글자수 : " + str.trim().length());

//toUpperCASE() : 무조건 대문자로 변환한다.
        System.out.println("무조건 대문자로 : " + str.toUpperCase());

//toLowerCASE() : 무조건 소문자로 변환한다.
        System.out.println("무조건 소문자로 : " + str.toLowerCase());

//charAt(index) : 문자열에서 index+1 번째 문자를 얻어온다. 문자열의 index는 0부터 시작한다.
        System.out.println("7번째 문자 : " + str.charAt(6));

//substring(a) : 문자열의 a번째 문자부터 끝까지 가져온다.
        System.out.println(str.substring(3));

//substing(a, b) : 문자열의 a번째 문자부터 b-1번째까지 문자까지 얻어온다.
        System.out.println(str.substring(3, 6));

//indexOf() : 문자열의 왼쪽부터 검색해서 인수로 지정된 문자열이 처음 나타나는 위치를 얻어온다.
        System.out.println(str.indexOf("it"));

//lastIndexOf() : 문자열 오른쪽부터 검색해서 인수로 지정된 문자열이 처음 나타나는 위치를 얻어온다.
        System.out.println(str.lastIndexOf("it"));

//contain() : 문자열에 인수로 지정된 문자열이 포함되어 있으면 true, 없으면 false를 리턴한다.
        System.out.println(str.contains("it"));

//matches() : 문자열이 인수로 지정된 문자열과 일치하면 true, 아니면 false를 리턴한다.
        System.out.println(str.matches("it"));
        sc.close();
    }
}
