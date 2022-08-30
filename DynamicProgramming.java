import java.io.*;
import java.util.Arrays;

public class DynamicProgramming {

}

    /*
     * 2022-08-30
     * 문제출저: 백준 11051번, 이항계수2
     * 문제: 매우 큰 조합의 경우의 수 구하기
     * 배울점: 파스칼의 삼각형 공식: nCr = n-1Cr + n-1Cr-1
     *        다이나믹프로그래밍 바텀업, 탑다운 방식으로 풀이 가능
     *        매우 큰 수이므로 모듈라 조건을 넣음
    static int[][] dp;

    //nCr의 개수를 구해주는 재귀함수
    public static int pascal(int n, int r){
        //이미 계산되어 있는거면 바로 리턴
        if(dp[n][r] > 0)
            return dp[n][r];

        if(n == r || r == 0)
            dp[n][r] = 1;
        else
            dp[n][r] = (pascal(n-1,r-1) + pascal(n-1,r)) % 10007;

        return dp[n][r];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int r = Integer.parseInt(str[1]);
        dp = new int[n+1][];

        //필요한 만큼만 2차원 공간 할당
        for(int i=0; i<=n; i++)
            dp[i] = new int[i+1];

        //바텀업 방식
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i; j++){
                //1주는 조건
                if(j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;
            }
        }

        bw.write(dp[n][r] + "\n");

        //탑다운 방식
        //System.out.println(pascal(n,r));

        //배열 출력해보기
        //for(int i=0; i<=n; i++)
        //	System.out.println(Arrays.toString(dp[i]));

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-08-30
     * 문제출저: 백준 9461번, 파도반 수열
     * 문제: 삼각형을 나선형으로 추가할때 가장 긴 변의 길이 구하기
     * 배울점: 케이스를 그려 나가면 피보나치와 비슷한 점화식을 끌어낼 수 있다.
     *        An = An-1 + An-5
    static long[] dp;

    public static long padovan(int N){
        //계산 했던거면 바로 리턴
        if(dp[N] > 0)
            return dp[N];

        if(N == 1 || N == 2 || N == 3)
            dp[N] = 1;
        else if(N == 4 || N== 5)
            dp[N] = 2;
        else
            dp[N] = padovan(N-1) + padovan(N-5);

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        //100항 까지 수행
        dp = new long[101];
        padovan(100);

        //입력된 항을 출력
        while(num-- > 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-30
     * 문제출저: 백준 1904번, 01타일
     * 문제: 00타일과 1타일을 조합할 수 있는 경우의 수
     * 배울점: 6항 정도까지 계산해보면 피보나치 수열임을 알 수 있다.
     *        매우 큰 수를 구해야 하므로 모듈라 조건을 주는데, dp[N]을 구할때 적용하면 된다
     *        (a + b) % m = (a % m + b % m ) % m
    static int[] dp;

    public static int fibo(int N){
        //계산 했던거면 바로 리턴
        if(dp[N] > 0)
            return dp[N];

        if(N == 1 || N == 2)
            dp[N] = 1;
        else
            dp[N] = (fibo(N-1) + fibo(N-2)) % 15746;

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+2];

        bw.write(fibo(N+1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-08-28
     * 문제출저: 백준 9184번, 신나는 함수 실행
     * 문제: 복잡한 재귀함수에 DP를 적용시키기
     * 배울점: 복잡해 보이지만 w(a,b,c)에 대한 값만 미리 계산해서 배열에 넣어두면 된다. 
     *        a b c 가 0보다 작거나 20보다 큰 경우는 값이 정해져 있기 때문에 배열 공간은 21까지만 생성한다.
     *        계산된 값이 있으면 바로 리턴해 주고, 없으면 원래 로직대로 계산해 보는게 핵심
    static int count = 0;
    static int[][][] dp = new int[21][21][21];

    //w재귀함수
    public static int w(int a, int b, int c){

        //구해놓은게 있으면 바로 리턴
        if(a >= 0 && b >= 0 && c >= 0 && a <= 20 && b <= 20 && c <= 20 && dp[a][b][c] > 0)
            return dp[a][b][c];

        //-----여기 이후는 a b c 가 음수이거나 구해놓은게 없는 경우-----

        if(a <= 0 || b <= 0 || c <= 0)
            return 1;

        //-----여기 이후는 a b c 가 자연수인 경우임-----

        if(a > 20 || b > 20 || c > 20){
            dp[20][20][20] = (dp[20][20][20] == 0) ? w(20,20,20) : dp[20][20][20];
            return dp[20][20][20];
        }

        //-----여기 이후는 a b c 가 20이하의 자연수-----

        if(a < b && b < c){
            dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
            return dp[a][b][c];
        }

        dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        return dp[a][b][c];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a==-1 && b==-1 && c==-1)
                break;

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-28
     * 문제출저: 백준 24416번, DP로 피보나치 수열 구현
     * 문제: 일반 피보나치 수열과 DP 피보나치 수열의 속도를 비교
     * 배울점: DP피보나치는 재귀(탑다운)로 구현할 수도 있지만, for문(바텀업)으로 구현할 수도 있다.
    static int count = 0;
    static int[] dp;

    //일반 피보나치
    public static int fibo(int n){
        if(n == 1 || n == 2){
            count++;
            return 1;
        }

        return fibo(n-1) + fibo(n-2);
    }


    //DP 피보나치
    public static int fibonacci(int n){

        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            count++;
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        fibo(n);
        bw.write(count + " ");
        count  = 0;
        fibonacci(n);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-08-22
     * 문제출저: 백준 2839번 문제
     * 문제: 설탕 배달, 설탕 5kg, 3kg 으로 담을 때 개수가 최소한으로 되도록
     * 배울점: 수학적으로 풀어도 되지만 DP연습할겸 풀어 봄
     *        i-3, i-5와 같은 연산을 하기전에 해도되는지 검사해보도록 한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            int min = 9999;
            //3을 빼도 되는지
            if(i-3 >= 0)
                min = Integer.min(min, dp[i-3]);
            //5를 빼도 되는지
            if(i-5 >= 0)
                min = Integer.min(min, dp[i-5]);

            min = min == 9999 ? min : min+1;
            dp[i] = min;
        }

        System.out.println(dp[N] == 9999 ? -1 : dp[N]);

        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-15
     * 문제출저: 동빈나 DP 강의
     * 문제: 병사 줄세우기. 전투력 내림차순 이면서, 병사수를 최대로 하고싶을때 몇명인지 구하기
     * 배울점: LIS(Longest Increasing Subsequence)알고리즘을 적절히 변형하여 풀이
              특정 인덱스 i 입장에서 0~i-1까지 숫자들 중에 나보다 큰놈이 있는가?
      public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            dp[i] = 1;
        }

        //모든 원소들에 대하여 탐색
        for(int i = 0; i < N; i++){
            //0부터 나보다 이전까지 탐색
            for(int j = 0; j < i; j++){
                //나보다 큰걸 발견하면 갱신을 시도한다.
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        //dp[]에서 최대값 찾아내기
        int max = -1;
        for(int i = 0; i < N; i++)
           max = Math.max(max, dp[i]);

        System.out.println(Arrays.toString(dp));
        System.out.println(max);
        System.out.println(N - max);
    }*/


    /*
     * 2022-08-15
     * 문제출저: 동빈나 DP 강의
     * 문제: 금광 문제 → 대각선 위, 오른쪽, 대각선 아래로 이동하면서 금을 최대로 얻을 수 있는 경우 찾기
     * 배울점: 각 열마다 최대로 얻을 수 있는 금의 개수를 적립하면서 나아감
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);
        int[][] matrix = new int[M][N];
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, -1, -1};

        //행렬 채워넣기
        str = br.readLine().split(" ");
        int index = 0;
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(str[index++]);
        }

        for(int i = 0; i < M; i++)
            System.out.println(Arrays.toString(matrix[i]));

        //1열부터 끝까지 반복
        for(int i = 1; i < N; i++){
            //모든 행을 확인하면서 기대값 계산
            for(int j = 0; j < M; j++){
                int max = -1;
                //내 앞의 3방향을 보고 가장 큰거 가져오기
                for(int k = 0; k < 3; k++){
                    int nextX = j + dx[k];
                    int nextY = i + dy[k];

                    //배열인덱스 검사
                    if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N)
                        continue;

                    //최대값 구하기
                    max = Math.max(matrix[nextX][nextY],max);
                }
                //갱신
                matrix[j][i] += max;
            }
        }

        for(int i = 0; i < M; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }*/


    /*
     * 2022-08-15
     * 문제출저: 동빈나 DP 강의
     * 문제: 효율적인 화폐 구성 → 여러개의 화폐가 있을때 특정 숫자를 만족시키는 화폐의 최소 개수 구하기
     * 배울점: 강의랑 다르게 Greedy 기법에 dp를 사용해서 해결함
     *        Arrays.sort(), Arrays.fill() 사용
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] money = new int[N];
        int[] dp = new int[M+1];

        //화폐 입력받기
        for(int i = 0; i < N; i++)
            money[i] = Integer.parseInt(br.readLine());
        Arrays.sort(money);

        //dp[]을 -1로 초기화 한다.
        Arrays.fill(dp, -1);
        dp[0] = 0; //금액 0은 예외로 0으로 초기화

        //dp[]를 채워나간다.
        for(int i = money[0]; i <= M; i++){
            //가장 큰 화폐부터 점검(Greedy)
            for(int j = money.length-1; j >= 0; j--){
                int temp = i - money[j]; //목표 금액에서 현재 화폐단위를 뺀 값
                //temp가 만들 수 없는 금액이면 다음 화폐를 보자
                if(temp < 0 || dp[temp] == -1)
                    continue;
                //dp[temp]만큼의 화폐 개수에다가 현재 j화폐를 얹으므로 1을 추가 해준다.
                dp[i] = dp[temp] + 1;
                break;
            }
        }

        System.out.println(Arrays.toString(money));
        System.out.println(Arrays.toString(dp));
    }*/


    /*
     * 2022-08-14
     * 문제출저: 동빈나 DP 강의
     * 문제: 5로나누기, 3으로나누기, 2로나누기, 1빼기 연산중 하나를 수행하여 1로 만들 수 있는 최소 연산 횟수 구하기
     * 배울점: dp[]에 어떤값이 들어가야할지 생각하면서 연산을 하나씩 수행 해본다.
     *
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X+1];

        dp[0] = -1;
        dp[1] = 0;

        //2부터 X까지 dp배열을 채워넣는다.
        for(int i = 2; i <= X; i++){
            int min = Integer.MAX_VALUE;
            //5로 나누어지는가
            if(i % 5 == 0)
                min = Math.min(min, dp[i/5]);
            //3으로 나누어지는가
            if(i % 3 == 0)
                min = Math.min(min, dp[i/3]);
            //2로 나누어지는가
            if(i % 2 == 0)
                min = Math.min(min, dp[i/2]);
            //-1해야됨
            min = Math.min(min, dp[i-1]);

            dp[i] = min + 1;
        }

        bw.write(dp[X] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-10
     * 문제출저: 동빈나 DP 강의
     * 문제: 개미전사문제. 1차원 배열 형태의 집에서 하나의 집을 공격하면 이웃한 집은 공격할 수 없다. 약탈을 최대로 하기 위해선 어떻게 해야할까
     * 배울점: 어떻게 이런 생각을 할까..? a1, a2항까지의 최적의 해를 구하고 a3부터는 앞항을 이용해 최적의 해를 구한다 > 점화식을 만든다
     *        An = MAX(n + An-2 , An-1) , Math.max(a,b) 활용
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] dp = new int[N];

        //배열 입력받기
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str[i]);

        //처음 2개의 항
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        //2항부터 점화식대로 진행
        for(int i = 2; i < N; i++)
            dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]);

        System.out.println(Arrays.toString(dp));

        bw.write(dp[N-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/