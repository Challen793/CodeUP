import java.io.*;

public class Implement {


}

    /*
     * 2022-08-02
     * 문제출저: 동빈나 구현 강의
     * 문제: 시분초에서 3이 포함된 경우의 수 구하기
     * 배울점: 문자열 contains를 썼지만, hour/10, hour%10을 써서 숫자로 3이 있는지 체크해볼 수도 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        int hour = 0;
        int count = 0;

        while(hour <= N){
            for(int i = 0; i < 60; i++){
                for(int j = 0; j < 60; j++){
                    String str = Integer.toString(hour) + Integer.toString(i) + Integer.toString(j);
                    count = str.contains("3") ? count+1 : count;
                }
            }
            hour++;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-02
     * 문제출저: 동빈나 구현 강의
     * 문제: 상하좌우 이동하기
     * 배울점: moveChar 배열을 정의하여 입력된 키워드에 맞게 벡터이동

    //좌 우 상 하 순서대로 이동
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static String[] moveChar = {"L","R","U","D"};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int x = 0;
        int y = 0;
        int print = 1;

        //N+1 2차원 리스트를 생성
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<Integer>());
            for(int j = 0; j < N; j++)
                graph.get(i).add(0);
        }

        //첫 좌표 찍어보기
        graph.get(x).set(y,print++);

        String[] str = br.readLine().split(" ");

        //입력한대로 이동해보기
        for(int i = 0; i < str.length; i++){
            String move = str[i];
            int nextX = 0;
            int nextY = 0;

            //다음 좌표 구하기
            for(int j = 0; j < 4; j++){
                if(move.equals(moveChar[j])){
                    nextX = x + dx[j];
                    nextY = y + dy[j];
                }
            }

            //벽넘어가면 안됨
            if(nextX < 0 || nextY < 0 || nextX == N || nextY == N)
                continue;

            //이동해보기
            x = nextX;
            y = nextY;
            graph.get(x).set(y,print++);
        }

        //출력
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                System.out.print(graph.get(i).get(j) + " ");
            System.out.println();
        }

        bw.write(++x + " " + ++y);
        bw.flush();
        bw.close();
        br.close();
    }*/
