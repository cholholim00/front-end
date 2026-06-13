package JAVA;

public class PracticeTest {
    public static void main(String[] args) {

        int array[] = new int[5]; //크기가 5인 배열 생성

        for (int i = 0; i <= 5; i++) {
            try { //예외가 발생될 것으로 예상되는 문장
                array[i] = i+1;
                System.out.println("array[" + i + "] =" + array[i]);
            } catch (Exception e) { //예외가 발생되면 실행할 문장
                System.out.println("배열의 크기가 작아서 더이상 저장할 수 없습니다. ");
            } finally { //예외 상관없이 무조건 실행할 문장
                System.out.println("반복문이" + (i+1) + "번 실행되었습니다.");
            }
            // 배열의 크기가 5인데 6번 실행하라고 하였으므로 오류 발생
        }
    }
}
