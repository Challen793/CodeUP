import java.io.*;
import java.util.*;

public class QueueDS {

}

    /* 2022-06-28
     * 문제출저: 백준 10866번
     * 문제: 덱(Deque) 클래스 기초 사용법
     * 배울점: 추가로 덱에 있는 값을 순회하거나, contain으로 포함된 값을 찾거나, 앞 혹은 뒤쪽에서부터 값을 찾아나가 삭제시키는 메소드가 존재한다.
     *
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        //n회 만큼 반복하며 덱 관련 명령어를 수행
        while(n-- > 0){
            StringTokenizer stokn = new StringTokenizer(br.readLine());
            String command = stokn.nextToken();

            if(command.startsWith("push_front"))
                deque.offerFirst(Integer.parseInt(stokn.nextToken()));

            else if(command.startsWith("push_back"))
                deque.offerLast(Integer.parseInt(stokn.nextToken()));

            else if(command.startsWith("pop_front"))
                sb.append( deque.isEmpty() ? "-1\n" : deque.pollFirst()+"\n" );

            else if(command.startsWith("pop_back"))
                sb.append( deque.isEmpty() ? "-1\n" : deque.pollLast()+"\n" );

            else if(command.startsWith("size"))
                sb.append(deque.size()+"\n");

            else if(command.startsWith("empty"))
                sb.append( deque.isEmpty() ? "1\n" : "0\n" );

            else if(command.startsWith("front"))
                sb.append( deque.isEmpty() ? "-1\n" : deque.peekFirst()+"\n" );

            else if(command.startsWith("back"))
                sb.append( deque.isEmpty() ? "-1\n" : deque.peekLast()+"\n" );
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }*/

    /* 2022-06-27
     * 문제출저: 백준 1158번
     * 문제: 요세푸스 수열, N명의 사람이 원으로 앉아있고 K번째 사람을 계속 제거 해서 나오는 수열
     * 배울점: 원형 큐, LinkedList, Iterator등을 생각했지만 일반적인 선형 큐로 풀 수 있다.
     *        메모리초과가 나서 split > StringTokenizer로 바꾸고 StringBuilder를 활용했다.
     *        계속 출력초과, 메모리초과가 났었는데 "무한반복문에서 큐 사이즈 1체크 후 break"를 수정해주니깐 넘어감..
     *
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stokn = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stokn.nextToken());
        int k = Integer.parseInt(stokn.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        //큐 초기화
        for(int i = 1; i <= n; i++)
            queue.offer(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        //특정 행위를 계속 반복
        while(queue.size() > 1){
            //k-1번만큼 큐에서 값을 제거하고 다시 채워 넣음
            for(int i = 0; i < k-1; i++)
                queue.offer(queue.poll());

            //값을 제거하고 출력
            sb.append(queue.poll() + ", ");
        }

        //마지막으로 큐에 남은 숫자 1개를 출력
        sb.append(queue.poll() + ">");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }*/


    /* 2022-06-26
     * 문제출저: 백준 10845번
     * 문제: 큐 기초
     * 배울점: Queue클래스 기초 사용법, 가장 최근에 넣은 값을 가져오는 함수는 없음
     *
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String command = "";
        String[] str = null;
        int back = 0;

        //n회 반복하며 명령어 수행
        while(n-- > 0){
            command = br.readLine();

            if(command.startsWith("push")){
                str = command.split(" ");
                back = Integer.parseInt(str[1]);
                queue.add(back);
            }

            else if(command.startsWith("pop"))
                bw.write(queue.isEmpty() ? -1+"\n" : queue.poll()+"\n");

            else if(command.startsWith("size"))
                bw.write(queue.size()+"\n");

            else if(command.startsWith("empty"))
                bw.write(queue.isEmpty() ? 1+"\n" : 0+"\n");

            else if(command.startsWith("front"))
                bw.write(queue.isEmpty() ? -1+"\n" : queue.peek()+"\n");

            else if(command.startsWith("back"))
                bw.write(queue.isEmpty() ? -1+"\n" : back+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/



