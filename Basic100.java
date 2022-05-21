import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic100 {

    public static void main(String args[]) throws IOException {

    }
}

    /* 코드업 1082번 문제
    * 2022-05-19
    * 16진수 구구단 출력
    * String → 16진수 : Integer.decode("0x" + str);
    * 16진수 → String : Integer.toHexString(hex);
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = Integer.decode("0x"+br.readLine());

        for(int i = 1; i <= 15; i++){
            System.out.printf("%X*%X=%X\n",temp,i,temp*i);
        }
    }*/


    /* 코드업 1025번 문제
    * 2022-05-10
    * 정수 입력받아 자리수별로 출력
    * 123456 → [100000],[20000],[3000],[400],[50],[6]
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String toknString = br.readLine();
        int toknInt = Integer.parseInt(toknString);
        int temp = 0;

        for(int i = toknString.length()-1; i >= 0 ; i--){
            temp = (toknInt % (int)Math.pow(10,i));
            System.out.println("[" + Integer.toString(toknInt - temp) + "]");

            toknInt = temp;
        }
    }*/


    /* 코드업 1008번 문제
     * 2022-04-05
     * 특정문자의 유니코드 값 알아내고 16진수 값으로 출력하는 방법
    public static void main(String args[]) {

        // 특수문자의 유니코드(16진수)값 알아내기
        System.out.printf("%x\n",(int)'┌');
        System.out.printf("%x\n",(int)'┬');
        System.out.printf("%x\n",(int)'┐');
        System.out.printf("%x\n",(int)'├');
        System.out.printf("%x\n",(int)'┼');
        System.out.printf("%x\n",(int)'┤');
        System.out.printf("%x\n",(int)'└');
        System.out.printf("%x\n",(int)'┴');
        System.out.printf("%x\n",(int)'┘');

        //16진수를 유니코드로 출력
        System.out.println("\u250c\u252c\u2510\n\u251c\u253c\u2524\n\u2514\u2534\u2518");

    }*/
