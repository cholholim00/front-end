package hoseoProject;
import java.util.Scanner;

 abstract class Car {
	@SuppressWarnings("unused")
	private String modelName;//차량이름
	@SuppressWarnings("unused")
	private String manufacturer;//제조업체
    protected int price;//가격
    protected int speed;//속도
    
// 생성자(부모)
public Car(String modelName, String manufacturer, int price, int speed) 
{
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.speed = speed;
}

// 추상 메소드
    public abstract void speedUp();//속도 UP
    public abstract void speedDown();//속도 DOWN
}
//생성자(자식-카)
class MyCar extends Car {
    private int fuel;
    private String owner;

    public MyCar(String modelName, String manufacturer, int price, int speed, int fuel, String owner) {
        super(modelName, manufacturer, price, speed);
        this.fuel = fuel;
        this.owner = owner;
    }

    @Override
    public void speedUp() {
        if (fuel > 0) {
            speed += 10;
            fuel -= 5;
            System.out.println("현재 속도 : " + speed + "km/h, 휘발유량 : " + fuel + "L");
        } else {
            System.out.println("연료 부족으로 속도를 올릴 수 없습니다.");
        }
    }

    @Override
    public void speedDown() {
        if (speed > 0) {
            speed -= 10;
            fuel -= 5;
            System.out.println("현재 속도 : " + speed + "km/h, 휘발유량 : " + fuel + "L");
        } else {
            System.out.println("최저 속도입니다.");
        }
    }
}
//생성자(자식-트럭)
 class Truck extends Car {
    private int LPG;
    private String employer;

    public Truck(String modelName, String manufacturer, int price, int speed, int LPG, String employer) {
        super(modelName, manufacturer, price, speed);
        this.LPG = LPG;
        this.employer = employer;
    }

    @Override
    public void speedUp() {
        //속도 업
    	 if (LPG > 0) {
             speed += 10;
            LPG -= 5;
             System.out.println("(myCar)현재 속도 : " + speed + "km/h, LPG량 : " + LPG + "L");
         } else {
             System.out.println("연료 부족으로 속도를 올릴 수 없습니다.");
         }
     }

    @Override
    public void speedDown() {
        //속도 다운
    	if (speed > 0) {
            speed -= 10;
            LPG -= 5;
            System.out.println("(truck)현재 속도 : " + speed + "km/h, LPG량 : " + LPG + "L");
        } else {
            System.out.println("최저 속도입니다.");
        }
    }
}
public class HOSE_2024201019 {

	public static void main(String[] args) {
		 int M;
		 int S;
		 boolean b=true;
			Scanner sc= new Scanner(System.in);
			 MyCar myCar = new MyCar("포르쉐 타이칸", "KOREA PORSCHE",32300 , 100, 105, "김치영");
			 Truck truck = new Truck("봉고 3", "KIA", 2500, 100, 105, "라람몰");
			 
		       while(b) {
	            System.out.println("<메뉴>");
	            System.out.println("---------------------------------");
				System.out.println("1. 자가용");
				System.out.println("2. 트럭"); 
				System.out.println("3. 메인메뉴");
				System.out.println("---------------------------------");
				System.out.println("선택하시오 : "); 
	            M = sc.nextInt();
	            switch(M) {
	            case 1: 
	            	 System.out.println("---------------------------------");
	 				 System.out.println("모델명 : 포르쉐 타이칸");
	 				 System.out.println("제조사 : KOREA PORSCHE");
	 				 System.out.println("가격 : 323,000,000원 (3억 2300만원)");
					 System.out.println("현재속도 :"+"100KM");
					 System.out.println("현재 배터리량 : "+"105L");
	 				 System.out.println("---------------------------------");
		        break;
	            case 2:
	            	 System.out.println("---------------------------------");
	            	 System.out.println("모델명 : BONGO-500");
	 				 System.out.println("제조사 : KIA");
	 				 System.out.println("가격 : 25,000,000원 (2500만원)");
					 System.out.println("현재속도 :"+"100KM");
					 System.out.println("현재 LPG량 : "+"50L");
	 				 System.out.println("고용주 : "+"라람몰");
	 				 System.out.println("---------------------------------");
		        break;
	            case 3:
	            	 System.out.println("---------------------------------");
	 				 System.out.println("보유한 차량이 없어요 처음으로 돌아가주세요.");
	 				 System.out.println("---------------------------------");
	            return;
	            }
		        
				
		        while(b) {
		        System.out.println("선택하시오 : ");
		        System.out.println("---------------------------------");
				System.out.println("1. 속도업(myCar) | 2. 속도 다운(myCar) | 3. (myCar)시동 OFF");
				System.out.println("---------------------------------"); 
				System.out.println("11. 속도업(truck) | 22. 속도 다운(truck) | 33. (truck)시동 OFF");
				System.out.println("---------------------------------");
		        S = sc.nextInt();
		   
		        switch(S) {
		        case 1:
		        myCar.speedUp();break;
		        case 11:
		        truck.speedUp();break;
		        case 2:
		        myCar.speedDown();break;
		        case 22:
		        truck.speedDown();break;
		        case 3:
		        case 33:	
		        b = false; 
		        System.out.println("시동 OFF");
				break;
				default:
		        }		        
		    }
	}
}
	}
