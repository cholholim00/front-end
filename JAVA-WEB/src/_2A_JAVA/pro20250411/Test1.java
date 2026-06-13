package _2A_JAVA.pro20250411;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			numList.add(i);
		}
				
		for(int i=0; i<numList.size(); i++) {
			System.out.println(numList.get(i));
		}
		
		Iterator<Integer> iter = numList.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

}
