import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import static java.lang.System.exit;

public class SearchExhaustive {


}

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


