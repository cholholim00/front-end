package _2A_JAVA.pro20250404;

public class Primary {
   private String name;
   private int Korean;
   private int english;
   private int Math;
   public Primary(String name, int Korean, int english, int Math) {
       this.name = name;
       this.Korean = Korean;
       this.english = english;
       this.Math = Math;
   }
   private int getMeans() {
       return (Korean + english + Math) / 3;
   }
   public String toString() {
       return " " +name + "학새의 평균은 " + getMeans() + "점 입니다.";
   }
}
