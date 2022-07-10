import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Basic100  {

}
    /* 코드업 1099번 문제
     * 2022-05-26
     * 2차원배열에서 먹이를 찾아 이동하기
     *
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[10][10];
        String[] str = null;

        //10*10 미로 입력 받기
        for(int i = 0; i < 10; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j< 10; j++){
                matrix[i][j] = Integer.parseInt(str[j].trim());
            }
        }

        //처음시작은 1,1
        int x = 1;
        int y = 1;

        while(true){
            //먹이를 찾았는가?
            if(matrix[x][y] == 2){
                matrix[x][y] = 9;
                break;
            }

            //오른쪽으로 이동을 시도
            if(matrix[x][y+1] == 1) { //오른쪽 이동불가
                //아래쪽으로 이동을 시도
                if(matrix[x+1][y] == 1){ //아래쪽 이동불가
                    matrix[x][y] = 9;
                    break;
                }
                else if(true){ //아래쪽 이동가능
                    matrix[x][y] = 9;
                    x++;
                }
            }
            else{//오른쪽 이동가능
                matrix[x][y] = 9;
                y++;
            }
        }

        //미로 출력하기
        for(int i = 0; i < 10; i++){
            for(int j = 0; j< 10; j++){
                System.out.print(matrix[i][j]);
                System.out.print( j == 9 ? "" : " ");
            }
            System.out.print( i == 9 ? "" : "\n");
        }
    }*/


    /* 코드업 1098번 문제
    * 2022-05-23
    * 2차원배열에 가로,세로 막대 놓기
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = null;
        str = br.readLine().split(" ");

        //전체 배열 크기 입력 및 0으로 초기화
        int width = Integer.parseInt(str[0].trim());
        int height = Integer.parseInt(str[1].trim());
        int[][] matrix = new int[width][height];

        //막대의 개수 만큼 반복
        int num = Integer.parseInt(br.readLine());
        for(int k=0; k<num; k++){

            //길이 len, 방향 direction(가로:0, 세로:1), 좌표(x,y)
            str = br.readLine().split(" ");
            int len = Integer.parseInt(str[0].trim());
            int direction = Integer.parseInt(str[1].trim());
            int x = Integer.parseInt(str[2].trim()) - 1;
            int y = Integer.parseInt(str[3].trim()) - 1;

            if(direction == 0){ //가로방향으로 막대 놓기
                for(int i=y; i<y+len; i++){
                    matrix[x][i] = 1;
                }
            }
            else if(direction == 1){ //세로방향으로 막대 놓기
                for(int i=x; i<x+len; i++){
                    matrix[i][y] = 1;
                }
            }
        }

        //배열 출력
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                System.out.print(matrix[i][j]);
                System.out.print( j == height-1 ? "" : " ");
            }
            System.out.print( i == width-1 ? "" : "\n");
        }
    }*/


    /* 코드업 1097번 문제
    * 2022-05-23
    * 2차원배열 십자가 모양으로 뒤집기
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[19][19];
        String[] str = null;

        //배열을 입력 받음
        for( int i = 0; i < 19; i++){
            str = br.readLine().split(" ");
            for( int j = 0; j < 19; j++){
                matrix[i][j] = Integer.parseInt(str[j].trim());
            }
        }

        //몇번 십자가 할지
        int num = Integer.parseInt(br.readLine());
        for( int k = 0; k < num; k++ ){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0].trim()) - 1; //십자가 중심 x축
            int y = Integer.parseInt(str[1].trim()) - 1; //십자가 중심 y축

            //십자 뒤집기 수행
            for( int i = 0; i < 19; i++ ){
                matrix[x][i] = (matrix[x][i] == 0 ? 1 : 0); //가로
                matrix[i][y] = (matrix[i][y] == 0 ? 1 : 0); //세로
            }
        }

        //배열 출력해보기
        for( int i = 0; i < 19; i++){
            for( int j = 0; j < 19; j++){
                System.out.print(matrix[i][j]);
                System.out.print( j == 19-1 ? "" : " ");
            }
            System.out.print( i == 19-1 ? "" : "\n");
        }
    }*/



    /* 코드업 1082번 문제
    * 2022-05-19
    * 16진수 구구단 출력
    * String → 16진수 : Integer.decode("0x" + str); 또는 Integer.valueOf(str, 16);
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
