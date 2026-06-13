package JAVA;

import java.util.ArrayList;

public class ArrayListTest2 {
    public static void main(String[] args) {
//ArrayList 클래스 문자열을 받는 배열을 생성한다.
        ArrayList<String> list = new ArrayList<String>();

// add(value) : ArrayList 맨 뒤에 value를 추가한다.
        list.add("홍길동");

// size() : ArrayList에 저장된 데이터의 개수를 얻어온다.
        System.out.println(list.size() + " : " + list); // 데이터 개수와 list출력

        list.add("임꺽정");
        System.out.println(list.size() + " : " + list);

        list.add("김춘향");
        list.add("김콩쥐");

// add(index, value) : ArrayList의 index 번째 위치에 value를 추가한다.
        list.add(1, "김춘자");
        System.out.println(list.size() + " : " + list);

// set(index, value) : ArrayList의 index 번째 위치의 값을 value로 수정한다.
        list.add(1, "이몽룡");
        System.out.println(list.size() + " : " + list);

        for (int i = 0; i < list.size(); i++) {
// get(index) : ArrayList의 index번째 위치의 값을 얻어온다.
            System.out.println("list.get("+ i +") = " + list.get(i));
        }


// remove(index) : ArrayList의 index번째 위치의 값울 삭제한다.
        list.remove(1);
        System.out.println(list.size() + " : " + list);

// clear() : ArrayList의 모든 데이터를 제거한다.
        list.clear();
        System.out.println(list.size() + " : " + list);
    }
}
