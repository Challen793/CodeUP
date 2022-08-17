public class ShortestPath {

}

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
        if(this.distance < other.getDistance()){ //현재 인덱스 값이 크면 우선순위가 높다.
            return -1; //this가 우선순위 높은 경우
        }
        return 1;
    }
}

public class ShortestPath {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int N, M, C;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] table;
    static boolean[] visited;

    public static void dijkstra(int start){

        //시작 노드를 만들어 큐에넣고, 초기 테이블을 설정한다.
        pq.offer(new Node(start, 0));
        table[start] = 0;

        //큐에 있는 내용들을 보면서 위 행위를 반복
        while(!pq.isEmpty()){
            //큐에서 노드를 꺼내본다.
            Node node = pq.poll();
            int distance = node.getDistance();
            int index = node.getIndex();

            //방문 했던 노드는 스킵한다.
            if(visited[index])
                continue;

            //현재노드를 방문처리 한다.
            visited[index] = true;

            //해당 노드랑 연결된 간선들을 살펴본다.
            for(int i = 0; i < graph.get(index).size(); i++){
                Node nextNode = graph.get(index).get(i);
                int nextIndex = nextNode.getIndex();
                int nextDistance = nextNode.getDistance();

                //table을 업데이트 하면 큐에 넣어준다.
                if(table[nextIndex] > table[index] + nextDistance){
                    table[nextIndex] = table[index] + nextDistance;
                    pq.offer(nextNode);
                }
            }
            System.out.println(Arrays.toString(table));
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
        for(int i = 0; i < N+1; i++)
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
        visited = new boolean[N+1];
        table = new int[N+1];
        Arrays.fill(table, Integer.MAX_VALUE);

        //다익스트라 함수 호출
        dijkstra(C);
    }
}*/
