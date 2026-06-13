package _2A_JAVA.pro20250404;

import java.util.Vector;

public class test1 {
    public static void main(String[] args) {
        Vector<Integer> age = new Vector<>();
        age.add(10);
        age.add(new Integer(20));
        age.add(30);
        age.set(1,100);
        for (int i = 0; i < age.size(); i++) {
            System.out.println(age.get(i));
        }
    }
}
