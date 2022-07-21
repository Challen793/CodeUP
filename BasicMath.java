import java.io.*;

public class BasicMath {


}

    /*
     * 2022-07-18
     * 문제출저: 백준 10870문제
     * 문제: 피보나치 수열
     * 배울점: 재귀적 풀이를 생각해낼 수 있음
    public static int pibo(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return pibo(n-1) + pibo(n-2);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(pibo(Integer.parseInt(br.readLine()))+"");

        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-07-17
     * 문제출저: 백준 2460문제
     * 문제: 기차역에서 승객이 타고 내릴때 최대 승객수를 구하기
     * 배울점:
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int temp = 0;
        int max = 0;

        //10회반복
        for(int i = 0; i < 10; i++){
            String[] str = br.readLine().split(" ");
            temp = temp + Integer.parseInt(str[1]) - Integer.parseInt(str[0]);

            if(max < temp)
                max = temp;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-07-17
     * 문제출저: 백준 10818문제
     * 문제: 입력받은 수 중에서 최소, 최대값 구하기
     * 배울점:
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        //첫번째 항 입력
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);

        //N개의 정수를 확인해가면서
        for(int i = 1; i < N; i++){
            int temp = Integer.parseInt(str[i]);

            if(max < temp)
                max = temp;

            if(min > temp)
                min = temp;
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-07-13
     * 문제출저: 백준 3460문제
     * 문제: 십진수를 이진수로 변환하고 1의 위치를 출력하기
     * 배울점: toBinaryString()을 쓰면 쉽게 풀 수 있다
     *        나머지를 이용해 풀면 2진수 뿐만아니라 N진수에 대해서도 풀 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        //나머지를 이용한 풀이
        //T만큼 반복
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int index = 0;
            //2로 나눠가면서 나머지가 1이면 위치를 출력
            while (n > 0) {
                if (n % 2 == 1)
                    bw.write(index + " ");
                n = n / 2;
                index++;
            }
            bw.write("\n");
        }

        //toBinaryString을 이용한 풀이
        //T만큼 반복
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(n);
            int length = binary.length() - 1;

            //끝에서부터 반복하면서 1을 찾는다.
            for (int j = length; j >= 0; j--) {
                if (binary.charAt(j) == '1')
                    bw.write(length - j + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-07-13
     * 문제출저: 백준 2501문제
     * 문제: N의 약수들 중 K번째 약수를 출력하기
     * 배울점:
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stokn = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stokn.nextToken());
        int K = Integer.parseInt(stokn.nextToken());
        int count = 0;
        int i = 1;

        //1부터 N까지 나누어보면서 약수를 찾는다.
        for (i = 1; i <= N; i++) {
            if (N % i == 0) //약수인경우 개수 증가
                count++;
            if (count == K) //K번째 약수이면 멈춤
                break;
        }

        System.out.println(count == K ? i : 0);
    }*/