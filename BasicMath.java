import java.io.*;
import java.util.Arrays;

public class BasicMath {

}

    /*
     * 2022-07-27
     * 문제출저: 백준 1978문제
     * 문제: 소수 판별하기
     * 배울점: Arrays.fill()함수로 배열의 모든 값을 채울 수 있다.
     *        에라토스테네스의 체 - N의 제곱근까지만 반복해보면 된다.
    static boolean[] primeNumber;

    public static void determinePrime(int n){

        //0,1제외하곤 모두 true로 채워두기
        Arrays.fill(primeNumber, true);
        primeNumber[0] = false;
        primeNumber[1] = false;

        //0,1은 소수가 아니므로 2부터시작
        for(int i = 2; i <= Math.sqrt(n); i++){
            //현재 숫자가 소수인 경우
            if(primeNumber[i]){
                //i를 제외한 i의 배수들은 모두 false
                int j = 2;
                while(i * j <= n){
                    primeNumber[i*j] = false;
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int count = 0;
        int max = 0;

        //입력된 숫자중에서 가장 큰 숫자를 알아낸다.
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(str[i]);
            if(max < temp)
                max = temp;
        }

        //에라토스테네스의 체를 활용하여 소수 배열 만들기
        primeNumber = new boolean[max+1];
        determinePrime(max);

        //입력된 숫자들에 대해서 소수 여부 판단
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(str[i]);
            if(primeNumber[n])
                count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }*/

    /*
     * 2022-07-25
     * 문제출저: 백준 2693문제
     * 문제: N번째로 큰 수 구하기
     * 배울점: ArrayList 정렬로 쉽게 구현 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        //N회 반복
        while(N-- > 0){
            String[] str = br.readLine().split(" ");
            for(int i = 0; i < str.length; i++){
                list.add(Integer.parseInt(str[i]));
            }
            list.sort(Comparator.reverseOrder());
            bw.write(list.get(2) + "\n");
            list.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-07-24
     * 문제출저: 백준 2609문제
     * 문제: 최대공약수, 최소공배수 구하기
     * 배울점: 유클리드호제법을 재귀로 구현하여 최대공약수 구한 뒤, 최소공배수도 구할 수 있다.
    public static int GCD(int a, int b){
        if(b == 0)
            return a;

        return GCD(b, a % b);
    }

    public static int LCM(int a, int b){
        return a * b / GCD(a,b);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        //크기 맞춰 주기
        if(b > a){
            int temp = a;
            a = b;
            b = temp;
        }

        //최대공약수 구하기
        bw.write(GCD(a, b) + "\n");

        //최소공배수 구하기
        bw.write(LCM(a, b) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }*/

    /*
     * 2022-07-25
     * 문제출저: 백준 10870문제
     * 문제: 피보나치 수열
     * 배울점: 재귀적 풀이를 생각해낼 수 있음, DP처럼 구현
     *
     static int[] dp;

    public static int pibo(int n){
        if(n == 0)
            return 0;

        else if(n == 1)
            return 1;

        else if(dp[n] == 0){
            dp[n] = pibo(n-1) + pibo(n-2);
        }

        return dp[n];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        bw.write(pibo(n)+"");

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