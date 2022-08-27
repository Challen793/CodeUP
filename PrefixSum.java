public class PrefixSum {

}

    /*
     * 2022-08-28
     * 문제출저: 백준 11659번 문제
     * 문제: 수열에서 주어지는 구간의 합을 출력하기(여러번 반복)
     * 배울점: 접두사 합 뼈대 문제, a~b구간합은 dp[b] - dp[a-1]
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        //수열 입력 받기
        str = br.readLine().split(" ");
        for(int i = 1; i <= N; i++)
        	arr[i] = Integer.parseInt(str[i-1]);

        //현재 항 까지의 합을 구해서 보관하기
        for(int i = 1; i <= N; i++)
            dp[i] = dp[i-1] + arr[i];

        //M번 구간합 계산해서 출력하기
        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int prefixSum = dp[b] - dp[a-1];
            bw.write(prefixSum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/
