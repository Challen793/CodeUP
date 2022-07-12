import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class SearchBFS {


}

    /*
     * 2022-07-11
     * 문제출저: 백준 1260
     * 문제: DFS와 BFS 기본
     * 배울점: 스스로 구현해본 DFS 및 BFS 함수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visitDFS;
    static boolean[] visitBFS;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int start){
        //현재 노드는 방문체크
        visitDFS[start] = true;
        sb.append(start + " ");

        //연결된 노드들에 대하여 체크해보자
        for(int i = 0; i < graph.get(start).size(); i++){

            //다음 노드를 획득
            int next = graph.get(start).get(i);

            //다음 노드가 방문되지 않았다면
            if(visitDFS[next] == false)
                dfs(next);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();

        //현재 노드 방문체크 및 큐삽입
        visitBFS[start] = true;
        queue.offer(start);
        sb.append(start + " ");

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            //타겟노드 꺼내오기
            int target = queue.poll();

            //타겟과 연결된 노드들을 보면서
            for(int i = 0; i < graph.get(target).size(); i++){
                int next = graph.get(target).get(i);

                //다음노드는 방문 되었는지?
                if(visitBFS[next] == false){
                    visitBFS[next] = true;
                    queue.offer(next);
                    sb.append(next + " ");
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);

        visitDFS = new boolean[N+1];
        visitBFS = new boolean[N+1];

        //노드 수만큼 ArrayList 생성
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        //간선 수만큼 반복하면서 그래프 생성
        for(int i= 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //오름차순으로 정렬
        for(int i = 0; i <= N; i++){
            graph.get(i).sort(Comparator.naturalOrder());
        }

        //DFS수행
        dfs(V);
        sb.append("\n");

        //BFS수행
        bfs(V);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }*/

    /*
     * 2022-07-10
     * 문제출저: 백준 24444, 24445
     * 문제: 그래프를 BFS방법으로 탐색하여 각 노드의 방문순서를 알아내기
     * 배울점: ArrayList를 사용해 2차원 행렬 형태로 노드들을 연결시켜주고 오름차순, 내림차순으로 정렬해준다.
    static int N = 0;
    static int M = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] visited = null;
    static int order = 1;

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        //시작점 방문체크, 큐에 삽입
        visited[start] = order++;
        queue.offer(start);

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){

            //큐에서 값을 꺼내서 확인
            int target = queue.poll();

            //연결된 노드들에 대하여 탐색
            for(int i = 0; i < graph.get(target).size(); i++){

                int next = graph.get(target).get(i);

                //아직 방문하지 않은 노드라면
                if(visited[next] == 0){
                    visited[next] = order++;
                    queue.offer(next);

                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int R = Integer.parseInt(str[2]);
        visited = new int[N+1];

        //graph 공간할당
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        //graph 간선정보 입력
        for(int i = 0; i < M; i++){
            String line[] = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //graph 오름차순으로 정렬
        for(int i = 1; i <= N; i++)
            graph.get(i).sort(Comparator.reverseOrder());

        //BFS탐색을 수행
        bfs(R);

        //방문순서를 출력
        for(int i = 1; i <= N; i++)
            bw.write(visited[i] + "\n");

        bw.flush();
        bw.close();
        br.close();

        //graph 출력해보기
        for(int i = 0; i <= N; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < graph.get(i).size(); j++)
                System.out.print(graph.get(i).get(j) + " ");

            System.out.println();
        }

    }*/



/*
 * 2022-07-10
 * 문제출저: 동빈나 BFS강의
 * 문제: BFS를 사용하여 미로 빠져나가는 최단경로 찾기
 * 배울점: 가장 빠를 것 같은 길을 예측해서 진행하는게 아님
 *        모든노드에 대하여 시작점으로부터의 거리가 몇인지 계산을 해봐야 함
 *        Matrix를 만들고 4방향 탐색을 하는것 → 그래프를 탐색하는 것과 같은 효과
 *        4방향 탐색: dx, dy 배열을 만들고 4번만 반복하면 된다.
static class Node{
    //멤버변수 정의
    private int x;
    private int y;

    //생성자 정의
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(SearchBFS.Node startNode, int N, int M){
        Queue<SearchBFS.Node> queue = new LinkedList<>();

        //시작노드는 거리 입력 후 큐에 넣는다.
        queue.offer(startNode);

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){

            //큐에서 값을 꺼내서 현재 좌표를 확인
            SearchBFS.Node node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            int distance = graph.get(x).get(y);

            //현재 노드의 상하좌우를 체크
            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                //배열을 초과하는 경우 예외처리
                if(nextX < 0 || nextY < 0 || nextX == N || nextY == M)
                    continue;
                //1인경우만 탐색을 수행
                if(graph.get(nextX).get(nextY) == 1){
                    //거리를 입력하고 큐에 넣어준다
                    graph.get(nextX).set(nextY, distance+1);
                    queue.offer(new SearchBFS.Node(nextX,nextY));
                }
            }
        }

        System.out.println("최단경로: " + graph.get(N-1).get(M-1));
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]); //세로개수
        int M = Integer.parseInt(str[1]); //가로개수
        int[] visited = new int[N+1];


        //세로 개수만큼 graph 초기화
        for(int i = 0; i < N; i++)
            graph.add(new ArrayList<Integer>());

        //이차원배열 형태로 graph에 입력
        for(int i = 0; i < N; i++){
            String line = br.readLine();

            for(int j = 0; j < M; j++)
                graph.get(i).add(line.charAt(j) - '0');
        }

        //BFS탐색 수행하며 경로를 기록
        SearchBFS.Node startNode = new SearchBFS.Node(0,0);
        bfs(startNode, N, M);

        //그래프 출력해보기
        for(int i = 0; i < N; i++){
            System.out.print(i + " : ");
            for(int j = 0; j < graph.get(i).size(); j++){
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-07-08
     * 문제출저: 동빈나 BFS강의
     * 문제: 기본 BFS 사용법
     * 배울점: 큐에 다음 탐색 대상노드들을 입력하고 계속 꺼내보면서 반복
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited = new boolean[8];

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        //시작점은 방문처리 후 큐에넣는다.
        visited[start] = true;
        queue.offer(start);
        System.out.println(start);

        //큐를 꺼내보면서 연결된 노드들을 방문처리하고 큐에 넣는다.
        while(!queue.isEmpty()){

            //큐를 꺼내본다.
            int target = queue.poll();

            //연결된 모든 노드들에 대하여 반복
            for(int i = 0; i < graph.get(target).size(); i++){

                int linkedTarget = graph.get(target).get(i);

                //연결된 노드가 미방문 상태이면
                if(visited[linkedTarget] == false){
                    //방문처리
                    visited[linkedTarget] = true;

                    //큐에 넣기
                    queue.offer(linkedTarget);

                    //방문순서 출력
                    System.out.println(linkedTarget + " ");
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        visited = new boolean[9];

        //graph 초기화
        for(int i = 0; i <= 8; i++){
            graph.add(new ArrayList<Integer>());
        }

        //graph에 입력
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

        bfs(8);

        bw.flush();
        bw.close();
        br.close();
    }*/