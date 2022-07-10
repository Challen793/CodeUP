import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Matrix {

}

    /* NHN 기출문제
     * 2022-07-03
     * 2차원배열에서 특정 영역이 몇개인지 계산
    static int n = 0;
    static int[][] matrix = null;

    public static int grouping(int i, int j){

        int result = 0;

        //현재값을 2로 변경하고 개수 증가
        matrix[i][j] = 2;
        result++;

        //총 8방향을 비교한다
        if(i > 0 && j > 0 && matrix[i-1][j-1] == 1)
            result += grouping(i-1, j-1);

        if(i > 0 && matrix[i-1][j] == 1 )
            result += grouping(i-1, j);

        if(i > 0 && j < n-1 && matrix[i-1][j+1] == 1)
            result += grouping(i-1, j+1);

        if(j > 0 && matrix[i][j-1] == 1)
            result += grouping(i, j-1);

        if(j < n-1 && matrix[i][j+1] == 1)
            result += grouping(i, j+1);

        if(i < n-1 && j > 0 && matrix[i+1][j-1] == 1)
            result += grouping(i+1, j-1);

        if(i < n-1 && matrix[i+1][j] == 1)
            result +=  grouping(i+1, j);

        if(i < n-1 && j < n-1 && matrix[i+1][j+1] == 1)
            result +=  grouping(i+1, j+1);

        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        String[] str = null;
        ArrayList<Integer> group = new ArrayList<>();

        //n*n 미로 입력 받기
        for(int i = 0; i < n; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j< n; j++){
                matrix[i][j] = Integer.parseInt(str[j].trim());
            }
        }

        //배열의 전체 원소를 보면서
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                //1인 원소를 발견하면 주변을 둘러보며 그룹핑 시작
                int result = 0;
                if(matrix[i][j] == 1){
                    result = grouping(i, j);
                    group.add(result);
                }
            }
        }

        //오름차순 정렬
        group.sort(Comparator.naturalOrder());

        //총 그룹 수 출력
        bw.write(group.size() + "\n");

        for(int i = 0; i < group.size(); i++){
            bw.write(group.get(i) + " ");
        }

        //출력해보기
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                bw.write(Integer.toString(matrix[i][j]));
                bw.write(j == matrix[i].length - 1 ? "" : " ");
            }
            bw.write(i == matrix.length - 1 ? "" : "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/


    /* 코드업 4085번 문제
     * 2022-06-08
     * 2차원배열 농사짓기 좋은 땅 고르기
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int x = Integer.parseInt(str[2]);
        int y = Integer.parseInt(str[3]);
        int k = 0; //비옥도
        int max = 0; //최대 비옥도


        //2차원 배열 생성
        int[][] matrix = new int[n][m];

        //2차원 배열에 입력
        for(int i = 0; i < n; i++){
            str = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        //영역을 지정할 수 있는 지점(i,j)만 돈다
        for(int i = 0; i <= n - y; i++){
            for(int j = 0; j <= m - x; j++){
                //비옥도를 계산
                k = sum(matrix, i, j, x, y);

                //비옥도를 최대값과 비교하여 갱신
                if(k > max) max= k;
            }
        }

        System.out.println(max);

        //전체 출력
        //print(matrix);
    }*/
