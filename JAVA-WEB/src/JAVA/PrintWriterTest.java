package JAVA;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintWriterTest {
    public static void main(String[] args) {
        Scanner sc = null; //스캐너 클래스 sc객체 선언
        PrintWriter printWriter = null; // printWriter 선언

        try { //예외 처리 구문
            //현재 프로젝트의 src폴더에 out.txt파일을 만든다
            String filename = "./src/out.txt";

            // PrintWriter 클래스의 객체를 생성하여 출력으로 사용할 파일을 open한다.
            printWriter = new PrintWriter(filename);
            sc = new Scanner(System.in);
            //시스템에서 입력하는 값을 sc에 넣는다.

            //QUIT가 입력될때까지 반복되며 키보드로 입력받은 데이터를 텍스트 파일로 출력한다.
            while (true) {
                System.out.print(">>> ");
                String str = sc.nextLine().trim(); // trim()은 불필요한 앞뒤 공백을 지운다

                if (str.length() != 0) { // trim() 처리했으므로 str에는 불필요한 값이 없다.

                    //입력받은 데이터가 "QUIT"면 무한 루프 탈출시킨다.
                if (str.toUpperCase().equals("QUIT")) {
                    break;
                }
                // write() 메소드 사용해 prinWriter 객체를 생성한 파일에 데이터를 출력한다.
                printWriter.write(str + "\r\n");
                // \r : carriage return, 커서를 줄의 맨 앞으로 보낸다.
                // \n : new Line, 줄을 바꾼다. \r\n 처리를 하면 한줄 엔터와 똑같다.
            }
            }
        System.out.println("저장완료! ");
    } catch (FileNotFoundException e) {
        System.out.println("디스크에 파일이 존재하지 않습니다.");
        e.printStackTrace();
    } finally {
//		출력 용도로 사용하는 파일은 작업이 완료되면 close로 닫아줘야 파일에 저장이 된다.
        if (printWriter != null) {
            printWriter.close();
            }
        }
    }
}
