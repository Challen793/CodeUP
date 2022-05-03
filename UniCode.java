
public class Main {

    public static void main(String args[]) {

        /* 코드업 1008번 문제
        * 2022-04-05
        * */
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

    }
}