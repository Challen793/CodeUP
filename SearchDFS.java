import java.io.*;
import java.util.ArrayList;

public class SearchDFS {


}


    /*
     * 2022-07-17
     * 문제출저: 백준 1012번
     * 문제: 직사각형 그래프에서 영역 지정하고 개수 구하기
     * 배울점: 직사각형 행렬일때 가로기준으로 1차원 리스트를 만들고 이후에 세로만큼 리스트를 달아준다.
     *        출력할때 graph.get(j).get(i) 이런식으로 해줘야 함
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int count = 2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;

    public static void dfs(int x, int y) {

        //배추 심겨져있으면
        if (graph.get(x).get(y) == 1)
            graph.get(x).set(y, count);

        //상하좌우를 살펴본다
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            //배열범위 체크
            if (nextX < 0 || nextY < 0 || nextX == M || nextY == N)
                continue;
            //다음 노드에 배추가 있으면 dfs 수행
            if(graph.get(nextX).get(nextY) == 1)
                dfs(nextX, nextY);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        //N회 반복하여 배추흰지렁이 수 출력
        while (T-- > 0) {
            String[] str = br.readLine().split(" ");
            M = Integer.parseInt(str[0]); //가로길이
            N = Integer.parseInt(str[1]); //세로길이
            int K = Integer.parseInt(str[2]); //배추개수

            //가로길이만큼 공간할당
            for (int i = 0; i < M; i++) {
                graph.add(new ArrayList<Integer>());
                //세로길이만큼 공간할당
                for (int j = 0; j < N; j++)
                    graph.get(i).add(0);
            }

            //배추 심어주기
            for (int i = 0; i < K; i++) {
                String[] line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                graph.get(x).set(y, 1);
            }

            //모든 땅에 대해 dfs를 수행
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(graph.get(i).get(j) == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            //애벌레 수를 기록
            bw.write(count-2 + "\n");

            //배추밭, 에벌레 초기화
            graph.clear();
            count = 2;
        }

        bw.flush();
        bw.close();
        br.close();
    }*/





    /*
     * 2022-07-11
     * 문제출저: 백준 2667번
     * 문제: 그래프에서 영역 지정하고 개수 구하기
     * 배울점: ArrayList를 사용해 2차원 행렬 형태로 노드들을 연결시켜주고 오름차순, 내림차순으로 정렬해준다.
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int N = 0;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y){

        //현재노드가 집이면 방문처리
        if(graph.get(x).get(y) == 1) {
            graph.get(x).set(y, 2);
            result++;
        }

        //현재 노드에 대해 방문 체크
        graph.get(x).set(y, 2);
        result++;

        //다음 4방향 노드에 대해
        for(int i = 0; i < 4; i++){

            //방향 이동 시도
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            //이동할 수 없는 경우
            if(nextX < 0 || nextY < 0 || nextX == N || nextY == N)
                continue;

            //다음 노드가 집이면 dfs수행
            if(graph.get(nextX).get(nextY) == 1)
                dfs(nextX,nextY);
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //행렬가로세로 개수
        ArrayList<Integer> home = new ArrayList<>();

        //이차원 행렬 만들기
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            graph.add(new ArrayList<Integer>());
            for(int j = 0; j < N; j++){
                graph.get(i).add(str.charAt(j) - '0');
            }
        }

        //모든원소를 탐색 하면서
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //집이면 dfs탐색을 시도한다
                if(graph.get(i).get(j) == 1){
                    result = 0; //집 개수 초기화
                    dfs(i,j);
                    home.add(result); //각 단지의 집 개수 담아두기
                }
            }
        }

        //오름차순 정렬
        home.sort(Comparator.naturalOrder());

        //출력준비
        bw.write(home.size() + "\n");

        for(int i = 0; i < home.size(); i++)
            bw.write(home.get(i) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-07-06
     * 문제출저: 백준 24479, 24480
     * 문제: 그래프를 DFS방법으로 탐색하여 각 노드의 방문순서를 알아내기
     * 배울점: ArrayList를 사용해 2차원 행렬 형태로 노드들을 연결시켜주고 오름차순, 내림차순으로 정렬해준다.
    static int order = 1;

    public static boolean dfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int target){

        //방문한 노드는 방문순서를 넣어준다.
        visited[target] = order++;

        //현재 노드와 연결된 노드들에 대해 동일하게 탐색
        for(int i = 0; i < graph.get(target).size(); i++) {
            //다음 노드가 방문되지 않았다면, dfs수행
            if(visited[graph.get(target).get(i)] == 0)
                dfs(graph, visited, graph.get(target).get(i));
        }

        return true;
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); //정점개수
        int M = Integer.parseInt(str[1]); //간선개수
        int R = Integer.parseInt(str[2]); //시작점
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        int[] visited = new int[N+1];

        //graph 초기화
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Integer>());
        }

        //graph에 입력
        for(int i = 1; i <= M; i++){
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            //무방향이므로 서로 연결시켜 준다
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //내림차순으로 정렬
        for(int i = 1; i <= N; i++){
            graph.get(i).sort(Comparator.reverseOrder());
        }

        //해당 노드를 기준으로 DFS탐색을 수행한다.
        dfs(graph, visited, R);

        //방문순서를 출력해준다
        for(int i = 1; i <= N; i++){
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

        //그래프 출력해보기
        for(int i = 1; i <= N; i++){
            System.out.print(i + " : ");
            for(int j = 0; j < graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }*/




    /*
     * 2022-07-06
     * 문제출저: 동빈나 DFS강의
     * 문제: 그래프를 DFS방법으로 탐색하여 영역을 지정하는 방법
     * 배울점: 2차원 행렬의 각 노드를 상하좌우로 연결시키는 그래프가 필요하다.
     *        현재 노드 기준으로 상하좌우로만 탐색을 하면 같은 영역인지 판단이 가능한 것이다. 8방향을 탐색해볼 필요까진 없다.
     *        dfs함수의 반환형은 bool이며 탐색할 필요가 없으면 즉시 false 반환하여 종료시킨다.

    static ArrayList<ArrayList<Character>> graph = new ArrayList<ArrayList<Character>>();
    static int n = 0; //세로길이
    static int m = 0; //가로길이

    public static boolean dfs(int i, int j){

        //0이 아니면 수행할 필요가 없다
        if(graph.get(i).get(j) != '0')
            return false;

        //현재 노드를 2로 변경
        graph.get(i).set(j,'2');

        //위 탐색
        if(i > 0)
            dfs(i-1, j);

        //아래 탐색
        if(i < n-1)
            dfs(i+1, j);

        //왼쪽 탐색
        if(j > 0)
            dfs(i, j-1);

        //오른쪽 탐색
        if(j < m-1)
            dfs(i, j+1);

        return true;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]); //세로길이
        m = Integer.parseInt(str[1]);//가로길이

        //graph 초기화
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Character>());
        }

        //graph에 입력
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                graph.get(i).add(line.charAt(j));
            }
        }

        int result = 0;
        //DFS탐색으로 0인부분을 2로 바꿔보자
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //모든 정점에 대하여 dfs탐색 수행
                if(graph.get(i).get(j) == '0') {
                    dfs(i, j);
                    result++;
                }
            }
        }

        //그래프 출력해보기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(graph.get(i).get(j));
            }
            System.out.println();
        }

        System.out.println(result + "개");
    }*/


    /*
    * 2022-07-04
    * 문제출저: 동빈나 DFS강의
    * 문제: 그래프를 DFS방법으로 탐색하는 방법
    * 배울점: 현재노드를 방문처리하고, 연결된 정점들에 대하여 방문처리를 하는 재귀함수 호출
    *        재귀함수로 구현했기에 Stack을 쓰지 않은듯 하다
    public static void dfs(int x, ArrayList<ArrayList<Integer>> graph, Boolean[] visited){
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y])
                dfs(y, graph, visited);
        }
    }

    public static void main(String args[]) throws IOException {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        Boolean[] visited = new Boolean[9]; //false로 초기화

        //graph 초기화
        for(int i = 0; i < 9; i++){
            graph.add(new ArrayList<Integer>());
            visited[i] = false;
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1, graph, visited);
    }*/