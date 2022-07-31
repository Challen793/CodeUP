import java.io.*;

public class SearchExhaustive {

}

    /*
     * 2022-07-31
     * 문제출저: 백준 14888번
     * 문제: 수열에 주어진 연산자를 끼워 넣어보면서 최대, 최소가 되는 경우의 값 구하기
     * 배울점: 순열이랑 비슷하게 완전탐색 하면서 선택된 연산자에 대해서 바로 계산
     *        Ingeter.MIN_VALUE, Integer.MAX_VALUE 사용
     *
    static int[] operator;
    static int[] num;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void exhaustiveSearch(int result, int index){
        //종료 조건
        if(index == N){
            max = max < result ? result : max;
            min = min > result ? result : min;
            return;
        }

        //매번 operator길이만큼 찾아본다.
        for(int i = 0; i < 4; i++){
            //선택
            if(operator[i] > 0){
                operator[i]--; //현재 연산자를 선택하고 다음 연산을 수행한다.

                if(i == 0)  exhaustiveSearch(result + num[index], index+1);
                else if(i == 1)  exhaustiveSearch(result - num[index], index+1);
                else if(i == 2)  exhaustiveSearch(result * num[index], index+1);
                else if(i == 3)  exhaustiveSearch(result / num[index], index+1);

                operator[i]++; //현재 선택된 연산 수행이 끝나면 다시 선택 안된 상태로 되돌려준다.
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        operator = new int[4];
        num = new int[N];

        //수열 만들기
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(str[i]);

        //연산자 배열 만들기
        str = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(str[i]);

        //완전탐색 하면서 숫자를 연산해나가자
        exhaustiveSearch(num[0], 1);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }

     */

    /*
     * 2022-07-31
     * 문제출저: 백준 14888번
     * 문제: 수열에 주어진 연산자를 끼워 넣어보면서 최대, 최소가 되는 경우의 값 구하기
     * 배울점: 모든 입력받은 연산자를 배열에 담고 순열(줄세우기) 함수를 호출하는 식으로 해결 함.
     *        완전탐색 재귀 - 백트래킹 방식으로 구현하는 방법이 있던데..
     *        순열 함수랑 로직은 비슷하지만 isChecked가 필요없는 방식임
    static boolean[] isChecked;
    static char[] answer;
    static char[] operator;
    static int[] num;
    static int N;
    static int max = -1000000000;
    static int min = 1000000000;

    public static void permutaion(int cnt){

        //재귀함수 종료조건
        if(cnt == N-1){
            //줄 세웠으니 계산 해보자
            int result = num[0];
            for(int i = 0; i < N-1; i++){
                int a = num[i+1];   //사용할 숫자
                char ch = answer[i]; //사용할 연산자

                if( ch == '+')
                    result += a;
                else if( ch == '-')
                    result -= a;
                else if( ch == '*')
                    result *= a;
                else if( ch == '/')
                    result /= a;
            }

            //max와 min판단하여 넣어주기
            max = max < result ? result : max;
            min = min > result ? result : min;
            return;
        }

        for(int i = 0; i < N-1; i++){
            //뽑혀있는지 확인
            if(isChecked[i])
                continue;

            isChecked[i] = true;
            answer[cnt] = operator[i];
            permutaion(cnt + 1);
            isChecked[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        isChecked = new boolean[N-1];
        answer = new char[N-1];
        operator = new char[N-1];
        num = new int[N];

        //수열 만들기
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(str[i]);

        //연산자 배열 만들기
        str = br.readLine().split(" ");
        int index = 0;
        for(int i = 0; i < 4; i++){
            int temp = Integer.parseInt(str[i]);
            char ch = i == 0 ? '+' : i == 1 ? '-' : i == 2 ? '*' : i == 3 ? '/' : 0;

            for(int j = 0; j < temp; j++)
                operator[index++] = ch;
        }

        //순열을 탐색하는 재귀함수 구현
        permutaion(0);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-07-24
     * 문제출저:
     * 문제: 순열, 중복순열, 조합, 중복조합, 부분집합 구하기
     * 배울점: 재귀함수로 구현했으며 자세한건 메모장에 정리 함
    static int N;
    static int R;
    static int[] arr = {3,5,7,9};
    static int[] answer;
    static boolean[] isChecked;

    //조합을 구현하는 재귀함수
    public static void combination(int start, int cnt){

        //재귀함수 종료조건
        if(cnt == R){
            System.out.println(Arrays.toString(answer));
            return;
        }

        //현재 값을 선택하고 다음 값들에 대해 재귀함수를 호출
        for(int i = start; i < N; i++){
            answer[cnt] = arr[i];
            combination(i+1, cnt + 1);
        }

    }

    //순열을 구현한 함수
    public static void permutaion(int cnt){
        //재귀함수 종료조건
        if(cnt == R){
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
        }

    }

    public static void main(String[] args) {
        N = 4;
        R = 2;
        answer = new int[R];
        isChecked = new boolean[N];

        //부분집합 구하기
        for(int i = 0; i <= N; i++){
            R = i;
            answer = new int[R];
            combination(0,0);
        }
        //permutaion(0);
    }*/


    /*
     * 2022-07-21
     * 문제출저: 백준 2309문제
     * 문제: 난쟁이 9명 중에 7명의 키의 합이 100이 되는 경우를 찾기
     * 배울점: 9명중에 7명을 뽑아내는 조합(Combination)을 이용하여 풀이 함
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static ArrayList<Integer> result = new ArrayList<Integer>();
    static int n = 9;
    static int r = 7;
    static int[] answer = new int[7];

    public static void comb(int start, int count) throws IOException{
        //종료조건 : r개만큼 다 뽑았을 때
        if(count == r){
            //7명의 키 합쳐보기
            int sum = 0;
            for(int i = 0; i < r; i++)
                sum += answer[i];

            //키의 합산이 100일때
            if(sum == 100){
                for(int i = 0; i < r; i++)
                    result.add(answer[i]);

                result.sort(Comparator.naturalOrder());

                for(int i = 0; i < r; i++)
                    bw.write(result.get(i) + "\n");

                bw.flush();
                bw.close();
                br.close();
                exit(0);
            }
            return;
        }

        //현재 노드부터 끝까지 확인해본다
        for(int i = start; i < n; i++){
            answer[count] = arr.get(i);
            comb(i+1,count+1);
        }
    }

    public static void main(String[] args) throws IOException {

        //난쟁이 키 입력받기
        for(int i = 0; i < 9; i++)
            arr.add(Integer.parseInt(br.readLine()));

        comb(0,0);
    }*/


