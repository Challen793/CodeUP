import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import static java.lang.System.exit;

public class SearchExhaustive {

}

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


