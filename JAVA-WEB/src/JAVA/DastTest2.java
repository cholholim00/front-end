package JAVA;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DastTest2 {
    public static void main(String[] args) {

        Date date = new Date(); //컴퓨터 시스템의 시각을 data에 가져온다.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss:S");

    System.out.println(sdf.format(date)); //data의 값을 sdf포맷에 넣어 출력

        System.out.println("년 : " + (date.getYear() + 1900)); //data의 연도율 가져옴
        System.out.println("월 : " + (date.getMonth() + 1)); //data의 월을 가져온다.
        System.out.println("일 : " + date.getDate()); //data의 일을 가져온다.
        System.out.println("요일 : " + date.getDay()); //data의 요일을 가져온다.
        System.out.println("시 : " + date.getHours()); //data의 시간을 가져온다.
        System.out.println("분 : " + date.getMinutes()); //data의 분을 가져온다.
        System.out.println("초 : " + date.getSeconds()); //data의 초를 가져온다.
        System.out.println("===============================");

        Calendar calendar = Calendar.getInstance(); //Calender 클래스로 현재 시각,날짜 가져옴
        System.out.println(calendar); //현재 시각 calender형식에 맞춰서 출력

        System.out.println("년 : " + calendar.get(Calendar.YEAR)); //연도 가져오기
        System.out.println("월 : " + (calendar.get(Calendar.MONTH) + 1)); //월 가져오기
        System.out.println("일 : " + calendar.get(Calendar.DATE)); //일 가져오기
        System.out.println("일 : " + calendar.get(Calendar.DAY_OF_MONTH)); //일 가져오기
        System.out.println("요일 : " + calendar.get(Calendar.DAY_OF_WEEK)); //일(1)..토(7)
        System.out.println("시 : " + calendar.get(Calendar.HOUR)); //12시간제
        System.out.println("시 : " + calendar.get(Calendar.HOUR_OF_DAY)); //24시간제
        System.out.println("분 : " + calendar.get(Calendar.MINUTE)); //분 가져오기
        System.out.println("초 ; " + calendar.get(Calendar.SECOND)); //초 가져오기
        System.out.println("밀리초 : " + calendar.get(Calendar.MILLISECOND)); //밀리초
    }
}
