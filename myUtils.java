import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class myUtils {

    /* String → 16진수 정수로 해석 */
    public int StringToHex(String str){
        return Integer.valueOf(str, 16);
    }

    /* 정수를 16진수로 해석하여 → String 변환 */
    public String StringToHex(int hex){
        return Integer.toHexString(hex);
    }

    /* char → int 변환 */
    public int CharToInt(char ch){
        return ch - '0';
        //다른 방법 return Character.getNumericValue(ch);
    }

    /* String을 뒤집기 */
    public String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /* 자연수 a, b를 입력 받고, a보다 작은 값 중에서,
    * b와 나누어떨어지기 위한 가장 가까운 수를 찾는다. */
    public int nearDisibleNumber(int a, int b){
        return (a * b) / b;
    }

    /* int형 2차원 배열에서 좌표,길이,높이 입력 받아 값을 합산 */
    public static int sum(int[][] matrix, int start_i, int start_j, int width, int height){
        int sum = 0;

        for( int i = start_i; i < start_i + height; i++ ){
            for( int j = start_j; j < start_j + width; j++){
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    /* 2차원 배열 출력하기 */
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(j == matrix[i].length - 1 ? "" : " ");
            }
            System.out.print(i == matrix.length - 1 ? "" : "\n");
        }
    }

    /* ArrayList 정렬 */
    public ArrayList<Integer> OrderByArrayList(ArrayList<Integer> arrayList, int option){
        //오름차순 정렬
        if(option == 0){
            arrayList.sort(Comparator.naturalOrder());                 //ArrayList를 사용한 오름차순 정렬
            //Collections.sort(arrayList);                             //Collections를 사용한 오름차순 정렬
            return arrayList;
        }

        //내림차순 정렬
        if(option == 1){
            arrayList.sort(Comparator.reverseOrder());                 //ArrayList를 사용한 내림차순 정렬
            //Collections.sort(arrayList, Collections.reverseOrder()); //Collections를 사용한 내림차순 정렬
            return arrayList;
        }

        return null;
    }

    /* dfs함수 템플릿 */
    public static void dfs(int x, int y) {
/*
        //조건에 따라 현재노드를 방문 체크
        if (graph.get(x).get(y) == 1)
            graph.get(x).set(y, count);

        //이동을 시도
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            //배열범위 체크
            if (nextX < 0 || nextY < 0 || nextX == M || nextY == N)
                continue;
            //다음 노드에 배추가 있으면 dfs 수행
            if(graph.get(nextX).get(nextY) == 1)
                dfs(nextX, nextY);
        }*/
    }

    /* bfs함수 템플릿 */
    public static void bfs(int start) {
        /*Queue<Integer> queue = new LinkedList<Integer>();

        //현재 노드 방문체크 및 큐삽입
        visitBFS[start] = true;
        queue.offer(start);
        sb.append(start + " ");

        //큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            //타겟노드 꺼내오기
            int target = queue.poll();

            //타겟과 연결된 노드들을 보면서
            for (int i = 0; i < graph.get(target).size(); i++) {
                int next = graph.get(target).get(i);

                //다음노드는 방문 되었는지?
                if (visitBFS[next] == false) {
                    visitBFS[next] = true;
                    queue.offer(next);
                    sb.append(next + " ");
                }
            }
        }*/
    }

    /* 조합 재귀함수 템플릿 */
    public static void combination(int start, int cnt){

       //재귀함수 종료조건
       /* if(cnt == R){
            System.out.println(Arrays.toString(answer));
            return;
        }

        //현재 값을 선택하고 다음 값들에 대해 재귀함수를 호출
        for(int i = start; i < N; i++){
            answer[cnt] = arr[i];
            combination(i+1, cnt + 1);
        }*/

    }

    /* 순열 재귀함수 템플릿 */
    public static void permutaion(int cnt){
        //재귀함수 종료조건
        /*if(cnt == R){
            System.out.println(Arrays.toString(answer));
            return;
        }

        for(int i = 0; i < N; i++){
            //이미 체크되어 answer에 들어있다면 패쓰
            if(isChecked[i])
                continue;

            //체크 안되어 있으면 체크해주고 재귀함수를 호출
            isChecked[i] = true; //현재값을 체킹
            answer[cnt] = arr[i];
            permutaion(cnt + 1);

            //내가 선택된 상태에서 모든경우의 수를 다 봤으니깐 체크 해제
            isChecked[i] = false;
        }*/
    }

    /* 최대공약수 구하기 */
    public static int GCD(int a, int b){
        if(b == 0)
            return a;

        return GCD(b, a % b);
    }

    /* 최소공배수 구하기 */
    public static int LCM(int a, int b){
        return a * b / GCD(a,b);
    }

    /* dp를 사용한 피보나치 수열 */

    static int[] piboNum;

    public static int pibo(int N){

        //0과 1은 따로 처리해준다.
        if(N == 0 || N == 1){
            piboNum[N] = N;
            return N;
        }

        //아직 값이 없는 항이면 계산해준다.
        if(piboNum[N] == 0)
            piboNum[N] = pibo(N - 2) + pibo(N - 1);

        return piboNum[N];
    }



    /* 에라토스테네스의 체를 활용한 소수 판별 함수 */
    public static void makePrime(int N) {
        //사전준비
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        //2부터 체로 걸러내기 시작
        for (int i = 2; i <= Math.sqrt(N); i++) {
            //i가 솟수가 아니면 체로 걸래낼 필요도 없음
            if (!prime[i])
                continue;

            //본인 제외 i의 배수들은 싹다 true로 변경
            int start = i * 2;
            while (start <= N) {
                prime[start] = false;
                start += i;
            }
        }
    }

    /* 10진수 M을 N진법 숫자로 변환 */
    public static String conversion(int M, int N){
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        //M이 0인경우 진법변환 수행하지 않는다.
        if(M == 0)
            return "0";

        //N진수로 변환하기
        while(M > 0){
            int num = M % N;
            //10보다 큰 수는 문자로 치환
            if(num >= 10){
                char ch = 55; //치환되기 위한 문자
                ch += num;
                sb.append(ch);
            }
            else
                sb.append(num);

            M = M / N;
        }
        return sb.reverse().toString();
    }
}
