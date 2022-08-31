import java.io.*;

public class Implement {


}

    /*
     * 2022-08-31
     * 문제출저: 백준 2447번, 별찍기-10
     * 문제: 재귀적인 패턴으로 별찍기
     * 배울점: 2차원 배열을 사용하여 별 또는 공백을 넣어줌
     *        출발지점(꼭지점)을 기준으로 좌표가 어떻게 반복 되는지 패턴을 찾아본다.
    static char[][] matrix;

    public static void star(int x, int y, int N, boolean blank){

        //공백을 넣어주는 경우
        if(blank){
            //N=3, x=3,y=3, true
            //N=1, x=1,y=1, true
            for(int i = x; i < x+N; i++){
                for(int j = y; j < y+N; j++)
                    matrix[i][j] = ' ';
            }
            return;
        }

        //*을 넣어주는 경우
        if(N == 1){
            matrix[x][y] = '*';
            return;
        }

        //다음 재귀함수를 호출해야하는 경우
        int size = N/3;
        int count = 0;

        //N=9 size=3 일때, (0 0)(0 3)(0 6)(3 0)(3 3)(3 6)(6 0)(6 3)(6 6)을 순회 해야 함
        //N=3 size=1 일때, (0 0)(0 1)(0 2)(1 0)(1 1)(1 2)(2 0)(2 1)(2 2)을 순회 해야 함
        //N=3 size=1 일때, (3 0)(3 1)(3 2)(4 0)(4 1)(4 2)(5 0)(5 1)(5 2)을 순회 해야 함
        for(int i = x; i < x+N; i += size){
            for(int j = y; j < y+N; j += size){
                count++;
                if(count == 5)
                    star(i, j, size, true);
                else
                    star(i, j, size, false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];

        star(0, 0, N, false);

        //matrix 출력하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                bw.write(matrix[i][j]);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-08-28
     * 문제출저: 백준 2941번, 크로아티아 알파벳
     * 문제: 기존 알파벳에 c= c- dz= d- lj nj s= z= 알파벳을 포함한 총 알파벳 개수 구하기
     * 배울점: 어려운 알고리즘은 아니지만 if문이 너무 많아져 복잡한 문제
     *        평번한 문자의 개수를 카운트하고 =, -, j 를 만났을때 스킵을 할지 카운트를 낮출지  판단
     *        스킵 할거 다 하고 마지막까지 도달 했을 때 카운트를 증가시키는게 핵심
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int count  = 0;
        int ch = 0;

        //문자를 하나씩 탐색
        for(int i = 0; i < str.length(); i++){
            ch = str.charAt(i);

            if(ch == '-') //  바로 스킵
                continue;

            if(ch == 'j'){
                char before = (i > 0) ? str.charAt(i-1) : ' ';
                if(before == 'n' || before == 'l') //nj랑 lj는 스킵
                    continue;
            }

            if(ch == '='){
                char before = (i > 0) ? str.charAt(i-1) : ' ';
                char twoBefore = (i > 1) ? str.charAt(i-2) : ' ';

                if(twoBefore == 'd' && before == 'z'){ //dz= 이면 카운트 감소후 스킵
                    count--;
                    continue;
                }

                if(before == 'c' || before == 's' || before == 'z') //c=, s= 스킵
                    continue;
            }

            //여기까지 도달했으면 일반 문자
            count++;
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-28
     * 문제출저: 백준 1316번 문제
     * 문제: 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
     * 배울점: 소문자 알파벳에 대해 배열을 만들고 나타났었는지 체크를 한다.
     *        연속으로 나타나는 문자는 스킵하고 이전과 다른 문자가 들어올때 체크로직을 수행한다.
    static boolean[] check = new boolean[27];

    public static int isGroup(String str){

        //체크 배열 초기화
        Arrays.fill(check, false);

        //첫번째 항 넣어주기
        char ch = str.charAt(0);
        check[ch-'a'] = true;

        //1부터 끝까지 돌면서
        for(int i = 1; i < str.length(); i++){
            char next = str.charAt(i);

            //같은 문자면 그냥 넘김
            if(ch == next)
                continue;

            //문자가 달라지면
            if(check[next-'a'])
                return 0;

            ch = next; //기준문자를 바꿔주고
            check[ch-'a'] = true; //새로운 문자를 체크
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;


        for(int i = 0; i < N; i++){
            String str = br.readLine();
            count += isGroup(str);
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-08-07
     * 문제출저: 동빈나 구현 강의
     * 문제: 문자열에서 알파벳은 순서대로정렬하고 숫자는 합산하여 마지막에 출력하기
     * 배울점:
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        int result = 0;

        //문자열 처음부터 끝까지 반복하면서
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch >= 65) //알파벳
                list.add(ch);
            else //숫자
                result += ch - '0';
        }

        //오름차순 정렬
        list.sort(Comparator.naturalOrder());

        //순서대로 출력하기
        for(int i = 0; i < list.size(); i++)
            bw.write(list.get(i));

        bw.flush();
        bw.close();
        br.close();
    }*/



    /*
     * 2022-08-07
     * 문제출저: 동빈나 구현 강의
     * 문제: 8*8 체스판에서 나이트가 움직일 수 있는 경우의 수
     * 배울점: 문자 a를 숫자 0으로 치환하려면 -'a' 문자 1을 숫자로 치환하려면 -'0'
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dx = {-2,-2,2,2,-1,1,-1,1};
        int[] dy = {-1,1,-1,1,-2,-2,2,2};
        String str = br.readLine();
        int count = 0;

        //x좌표 치환
        int x = str.charAt(1) - '0'-1;

        //y좌표 치환
        int y = str.charAt(0) - 'a';

        System.out.println("현재좌표: " + x + ", " + y);

        //다음 좌표 알아내기
        for(int i = 0; i < 8; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            //배열 넘어가는지 확인
            if(nextX < 0 || nextY < 0 || nextX == 8 || nextY == 8)
                continue;

            //이동 가능하면 카운트 증가
            count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/


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
