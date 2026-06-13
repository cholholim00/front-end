package _2A_JAVA.pro20250411;

import java.util.HashMap;
import java.util.Scanner;

public class quiz {

	public static void main(String[] args) {
		HashMap<String, Student> dic = new HashMap<String, Student>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("1.입력  2:조회  3:삭제[종료:exit]: ");
			String choice = sc.next();
			if (choice.toUpperCase().equals("EXIT")){
				System.out.println("종료합니다!");
				break;
			}
			
			sc.nextLine();
			
			if (choice.equals("1")) {
				System.out.print("[등록]학번 이름 학교 성별 나이: ");
				String value = sc.nextLine();
				System.out.println(value);
				String arr [] = value.split(" ");
				Student s = new Student(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]));
				dic.put(arr[0], s);
				System.out.println("등록하였습니다!");
			}else if(choice.equals("2")) {
				System.out.print("[조회]학번: ");
				String key = sc.next();
				System.out.println(dic.get(key));
			}else if(choice.equals("3")) {
				
			}
			
			
			
			
			
		}
		

	}

}
