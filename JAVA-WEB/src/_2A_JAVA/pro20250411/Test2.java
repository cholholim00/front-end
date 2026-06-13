package _2A_JAVA.pro20250411;

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		HashMap<String, String> dic = new HashMap<String, String>();
		dic.put("baby", "아기");
		dic.put("person", "사람");
		dic.put("student", "학생");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("찾고 싶은 단어[종료:exit]: ");
			String key = sc.next();
			if (key.toUpperCase().equals("EXIT")){
				System.out.println("Bye!");
				break;
			}
			String value = dic.get(key);
			if(value == null) {
				System.out.println("존재하지 않는 단어입니다!");
			}else {
				System.out.println(key + ": " + value);
			}
		}
		sc.close();
	}

}
