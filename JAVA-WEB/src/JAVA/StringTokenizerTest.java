package JAVA;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {

        // 문자열이 공백이나 탭으로 구분된 경우
        String str1 = "사과 배 복숭아        밤 대추";

        // StringTokenizer 클래스는 사용자가 지정하는 구분자를 경계로 해서 데이터를 나눠준다.
        // 구분자를 지정하지 않으면 공백이나 탭을 기본 구분자를 사용한다.
        StringTokenizer st1 = new StringTokenizer(str1);

        // hasMoreTokens() : StringTokenizer 객체에 다음 토큰이 있으면 true, 없으면 false를 리턴
        while (st1.hasMoreTokens()) {
            // nextToken() : 객체에서 다음 토큰을 읽어온다.
            System.out.println(st1.nextToken()); // 읽어온 토큰을 출력하고 한줄을 띄어쓰기
        }
        System.out.println("========================================");

        // 문자열이 ","로 구분된 경우
        String str2 = "사과,배,복숭아,밤,대추";
        // StringTokenizer 클래스 생성자의 2번째 인수로 구분자를 지정할 수 있다.
        StringTokenizer st2 = new StringTokenizer(str2, ","); // 구분자를 ","로 지정

        while (st2.hasMoreTokens()) {
            System.out.println(st2.nextToken());
        }
        System.out.println("========================================");
    }
}
