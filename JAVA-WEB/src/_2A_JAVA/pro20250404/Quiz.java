package _2A_JAVA.pro20250404;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        ArrayList<Primary> Students = new ArrayList<Primary>();
        Scanner s = new Scanner(System.in);
        String str;
        String [] items;

        while (true) {
            System.out.println("이름 국어 영어 수학[종료:exit]: ");
            str = s.nextLine();
            if (str.toUpperCase().equals("EXIT")) {
                break;
            }
            items = str.split(" ");
            Primary p = new Primary(items[0],
                 Integer.parseInt(items[1]),
                 Integer.parseInt(items[2]),
                 Integer.parseInt(items[3])
                 );
            Students.add(p);
        }
        for (int i = 0; i < Students.size(); i++) {
            System.out.println(Students.get(i));
        }
    }
}
