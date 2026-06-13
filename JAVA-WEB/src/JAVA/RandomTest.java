package JAVA;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {

        //랜덤 난수를 생성해주는 코드
        Random random = new Random();

        int[] lotto = new int[45]; // 45개짜리 lotto배열 생성
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = i + 1; //각 원소에 1부터 45까지의 숫자 저장
        }
        show(lotto);
        System.out.println("================ 섞기 전 ==================");

        for (int i = 0; i < 10000; i++) { // 반복 10000번 실행
            int n = random.nextInt(44) + 1; // n에 1부터 44중 랜덤난수 저장
            int m = lotto[0];
            lotto[0] = lotto[n];
            lotto[n] = m; //lotto[0]과 lotto[난수]의 수 바꾸기 코드
        }
        show(lotto);
        System.out.println("================ 섞기 전 ==================");
        // 1등 번호를 출력한다.
                System.out.print("1등 번호 : ");
        for (int i =0; i< 6; i++)	//1등번호 6개 뽑는 반복문
        {
            System.out.print(lotto[i] + " ");
            try {
                Thread.sleep(1000);	//1초씩 쉬면서 로또번호 추첨
            } catch (InterruptedException e) {
                e.printStackTrace();	//예외 처리 구문
            }
        }
        System.out.println("보너스 번호 : " + lotto[6]);
    }

    private static void show(int[] lotto) {	//show() 함수 구현
        for (int i =0; i< lotto.length ; i++)	//45번 반복
        {
            System.out.printf(" %2d ", lotto[i]);	//로또배열원소출력
            if (i % 10 == 9 || i+1 == lotto.length)
            {
                System.out.println();//10번 반복되거나 마지막 수면 엔터
            }
        }
    }
}
