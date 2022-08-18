public class ShortestPath {

}

    /*
     * 2022-08-18
     * 문제출저: 동빈나 최단경로 강의
     * 문제: 다익스트라 알고리즘 구현하기
     * 배울점: 우선순위큐에 내가만든 클래스를 넣는 방법, 우선순위 결정하기 위해 오버라이딩 하는방법
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[][] dp = new int[N+1][N+1];

        //matrix 전체 높은 수로 초기화
        for(int i = 0; i <= N; i++)
            Arrays.fill(dp[i], 9);

        //자기 자신으로 가는건 0으로 초기화
        for(int i = 0; i <= N; i++)
            dp[i][i] = 0;

        //matrix에 간선정보를 담기
        for(int i = 0; i < M; i++){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            dp[a][b] = 1;
            dp[b][a] = 1;
        }

        //모든 k를 거쳐가는 경우에 대하여
        for(int k = 1; k <= N; k++){
            //경로 i to j를 탐색해보자
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dp[i][j] = Integer.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }

        //배열 출력해보기
        System.out.println();
        for(int i = 1; i <=N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        str = br.readLine().split(" ");
        int X = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        System.out.println(dp[1][K] + dp[K][X]);

    }*/



    /*
     * 2022-08-18
     * 문제출저: 동빈나 최단경로 강의
     * 문제: 다익스트라 알고리즘 구현하기
     * 배울점: 우선순위큐에 내가만든 클래스를 넣는 방법, 우선순위 결정하기 위해 오버라이딩 하는방법
class Node implements Comparable<Node> {
    int index;
    int distance;

    //생성자 선언
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    //get함수 선언
    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    //오버라이드
    @Override
    public int compareTo(Node other){
        if(this.distance < other.getDistance()){
            return -1; //this가 우선순위 높은 경우
        }
        return 1;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int N, M, C;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] table;
    static boolean[] visited;

    public static void dijkstra(int start){
        //첫번째 노드에 대한 처리
        pq.offer(new Node(start,0));
        table[start] = 0;

        //큐가 빌때까지 수행한다.
        while(!pq.isEmpty()){
            //큐에서 노드를 뽑아본다.
            Node nowNode = pq.poll();
            int now = nowNode.getIndex();
            int nowDist = nowNode.getDistance();

            //방문했던 노드인지 점검
            if(visited[now])
                continue;

            //방문 표시 해준다.
            visited[now] = true;

            //현재 노드와 이어진 다른 노드들을 탐색한다.
            for(int i = 0; i < graph.get(now).size(); i++){
                Node nextNode = graph.get(now).get(i);
                int next = nextNode.getIndex();
                int nextDist = nextNode.getDistance();
                int cost = table[now] + nextDist; //현재 노드까지의 최단경로 + 다음 노드까지의 경로

                //table이 갱신되면 현재노드를 큐에 넣어준다.
                if(table[next] > cost){
                    table[next] = cost;
                    pq.offer(nextNode);
                }
            }
            System.out.println("최단경로: " + Arrays.toString(table));
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        C = Integer.parseInt(str[2]);

        //도시 개수만큼 graph의 1차원 공간 할당
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<Node>());

        //간선 정보 입력
        for(int i = 0; i < M; i++){
        	str = br.readLine().split(" ");
            int X = Integer.parseInt(str[0]);
        	int Y = Integer.parseInt(str[1]);
        	int Z = Integer.parseInt(str[2]);

            graph.get(X).add(new Node(Y,Z));
        }

        //테이블 초기화
        table = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(table, Integer.MAX_VALUE);

        //다익스트라 함수 호출
        dijkstra(C);

        //최단경로 테이블을 확인해보자
        int count = 0;
        int max = -1;
        for(int i = 1; i <= N; i++){

            if(table[i] < Integer.MAX_VALUE){
                count++;
                max = Integer.max(max, table[i]);
            }
        }

        bw.write(count-1 + " " + max);
        bw.flush();
        bw.close();
        br.close();
    }
}
}*/
