package JAVA;

public class ScoreTest {
    public static void main(String[] args) {
        ScoreList scoreList = new ScoreList();

        scoreList.addScore(new ScoreV0("홍길동", 72, 100, 99));
        scoreList.addScore(new ScoreV0("암꺽정", 12, 30, 99));
        scoreList.addScore(new ScoreV0("김콩쥐", 70, 50, 99));
        scoreList.addScore(new ScoreV0("김춘향", 75, 80, 99));
        scoreList.addScore(new ScoreV0("이몽룡", 100, 100, 100));

        System.out.println(scoreList);
    }
}
