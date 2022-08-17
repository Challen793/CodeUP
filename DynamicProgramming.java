import java.io.*;
import java.util.Arrays;

public class DynamicProgramming {

}

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