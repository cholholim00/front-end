package JAVA;
import java.util.ArrayList;

public class ScoreV0 {
    private static int count = 0; // 자동 번호 증가용
    private int number;
    private String name;
    private int java;
    private int jsp;
    private int spring;
    private int total;
    private double average;
    private int rank = 1;

    public ScoreV0(String name, int java, int jsp, int spring) {
        this.number = ++count;
        this.name = name;
        this.java = java;
        this.jsp = jsp;
        this.spring = spring;
        this.total = java + jsp + spring;
        this.average = total / 3.0;
    }

    public int getNo() {
        return number;
    }

    public void setNo(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getJsp() {
        return jsp;
    }

    public void setJsp(int jsp) {
        this.jsp = jsp;
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return String.format("    %d %s  %3d  %3d     %3d  %3d %6.2f   %d",
                number, name, java, jsp, spring, total, average, rank);
    }
}

class ScoreList {
    private ArrayList<ScoreV0> list = new ArrayList<>();

    public ArrayList<ScoreV0> getList() {
        return list;
    }

    public void setList(ArrayList<ScoreV0> list) {
        this.list = list;
    }

    public void addScore(ScoreV0 score) {
        list.add(score);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("==================================================\n");
        str.append(" 번호  이름  java  jsp  spring  총점  평균  석차\n");
        str.append("==================================================\n");

        // 석차 계산
        for (int i = 0; i < list.size(); i++) {
            ScoreV0 a = list.get(i);
            a.setRank(1); // 초기화
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getTotal() > a.getTotal()) {
                    a.setRank(a.getRank() + 1);
                }
            }
        }

        for (ScoreV0 vo : list) {
            str.append(vo).append("\n");
        }

        return str.toString();
    }
}
