package _2A_JAVA.pro20250404;

public class Psrson {
    private String name;
    private int age;
    public  String toStrin() {
        return "이름은"+name+"이고, 나이는"+age+"세 입니다.";
    }
    public Psrson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
