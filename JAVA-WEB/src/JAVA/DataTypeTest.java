package JAVA;

public class DataTypeTest {
    public static void main(String[] args) {
        // 변수와 자료형
        int i = 1; // 정수형 변수 i을 선언하고 1로 초기화
        short s = 2; // 정수형 변수
        long l = 3;
        float f = 4.56f; // float은 f를 붙여줘야 한다.
        double d = 7.89;
        char c = 'A'; // 문자형 변수 c을 선언하고 A로 초기화

        System.out.println("i의 값 : "+i); // "+"는 문자열을 더해서 출력하는 기능
        System.out.println("s의 값 : "+s);
        System.out.println("l의 값 : "+l);
        System.out.println("f의 값 : "+f);
        System.out.println("d의 값 : "+d);
        System.out.println("c의 값 : "+c); // "c의 값 : " 문자열과 "A"가 이어서 출력된다.
        System.out.println("######################################################");

        String name1 = "보안";
        String name2 = "컴공";
        System.out.println(name1 + name2);
        System.out.println("######################################################");

        // 기본 연산자
        int a = 5;
        int b = 6;

        System.out.println("a + b = " + (a + b)); //앞의 "+"과 구별하기 위해서 (a+b) 중괄호를 해줘야 한다.(덧셈)
        System.out.println("a - b = " + (a - b)); //뺼센
        System.out.println("a * b = " + (a * b)); //곱셉
        System.out.println("a / b = " + (a / b)); //a를 b로 나눈 몫이 나온다.
        System.out.println("a / b = " + ((double)a / b)); //a를 b로 나눈 값이 실수로 나온다.(형변환)
        System.out.println("a % b = " + (a % b)); //a를 b로 나눈 나머지가 나온다.
    }
}
