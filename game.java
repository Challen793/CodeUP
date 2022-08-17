import java.util.Random;
import java.util.Scanner;

public class game {

    public static void main(String[] args) throws InterruptedException {

        int myMoney = 10000000;
        int batting_Money = 0;
        int flag = 0;
        int martin = 100000;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();


        while(true) {
            System.out.println("---------------------------------------------------------" + i++ +"회차");
            System.out.println("현재 내가 가진 돈 : " + myMoney);
            System.out.println("배팅금액 : " + martin);
            //batting_Money = sc.nextInt();
            batting_Money = martin;

            if (batting_Money > myMoney) {
                myMoney -= batting_Money;
            } else {
                myMoney -= batting_Money;
            }

            flag = random.nextInt(2);
            System.out.println("플래그: " + flag);
            if (flag == 1) {
                System.out.println("도박성공!!");
                myMoney += batting_Money * 1.97;
                batting_Money = 0;
                martin = 100000;
            } else {
                System.out.println("도박실패..");
                batting_Money = 0;
                martin *= 2;
            }

            if(myMoney > 20000000 || myMoney <= 100000){
                System.out.println("게임종료");
                break;
            }

            Thread.sleep(1000);
        }
    }
}
