import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchDFS {

}

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