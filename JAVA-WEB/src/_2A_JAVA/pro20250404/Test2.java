package _2A_JAVA.pro20250404;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("국어, 영어, 수학 과목의 점수를 입력하세요 : ");
        String strScore = s.nextLine();
        String [] arrScore = strScore.split(" ");

        System.out.println("입력한 값1 : " + strScore);
        System.out.println("입력한 값2 : " + arrScore);
        System.out.println("입력한 값3 : " + arrScore.toString());
        System.out.println("=============================");
        for (int i = 0; i < arrScore.length; i++) {
            System.out.println(arrScore[i]);
        }
        System.out.println("=============================");
        for (String value: arrScore) {
            System.out.println(value);
        }







//        ArrayList<String> names = new ArrayList<String>();
//        System.out.println("이름을 입략하세요! : ");
//        for (int i = 0; i < 4; i++) {
//            names.add(s.next());
//        }
//        System.out.println("입력한 이름을 출력합니다.........");
//        for (int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }
    }
}
