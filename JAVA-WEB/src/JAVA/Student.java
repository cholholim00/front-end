package JAVA;

public class Student {
    private String name; // 이름
    private String number; // 학번
    private int age; // 나이
    private char grade; // 등급
    private double score; // 점수

 public void setName(String name) {
     this.name = name;
     }

 public String getNumber() {
     return number;
     }

 public void setNumber(String number) {
     this.number = number;
     }

 public int getAge() {
     return age;
     }

 public void getAge(int age) {
     this.age = age;
     }

 public char getGrade() {
     return grade;
     }

 public void getGrade(char grade) {
     this.grade = grade;
     }

 public double getScore() {
     return score;
     }

 public void getScore(double score) {
     this.score = score;
     }

     @Override
    public String toString() { // toString() : 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
         return "Student [name=" + name + ", number=" + number + ", age=" + age +
                 ", grade=" + grade + ", score=" + score + "]";
     }
     public Student(String name, String number, int age, char grade, double score) {
     super();
     this.name = name;
     this.number = number;
     this.age = age;
     this.grade = grade;
     this.score = score;
     }

    public static void main(String[] args) {
     Student student1 = new Student("홍길동", "1234567890", 23, 'A', 98.7);
     System.out.println(student1.toString());
    }
 }

