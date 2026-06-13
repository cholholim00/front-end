package _2A_JAVA.pro20250404;

public class Test3 {
    public static void main(String[] args) {
        Psrson p1 = new Psrson("홍길동",24);
        System.out.println(p1);
        Psrson p2 = new Psrson("홍길순", 18);
        System.out.println(p2);
        System.out.println("이름은 " +  p1.getName() + "이고, 나이는" + p1.getAge() + "세 입니다!");
        System.out.println(p1.toString());
        System.out.println(p1);
    }
}
