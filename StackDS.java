import java.io.*;

public class StackDS {

}

    /* 2022-06-30
     * 문제출저: 백준 10799번
     * 문제: 겹쳐진 막대기를 레이저로 잘랐을때 최종 막대기의 개수 구하기
     * 배울점: Stack 사용은 아니지만 처음에 Stack 사용으로 문제를 접근함
              ( 는 막대기를 쌓는거고, ()는 쌓여있는 막대기 수만큼 잘리는거고, )는 막대기 하나가 종료되는 것
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        boolean isLeft = false;
        int stick = 0;
        int result = 0;

        //문장 처음부터 끝가지 돌면서
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //'(' 경우
            if(ch == '('){
                isLeft = true;
                stick++; //스틱개수만 증가
            }
            else if(isLeft && ch == ')'){// '()' 인경우
                isLeft = false;
                stick--; //막대인줄 알았으나 레이저로 만들어졌기때문에 스틱 감소
                result += stick; //스틱개수만큼 잘린다
            }
            else if(!isLeft && ch == ')'){// '()' 인경우
                isLeft = false;
                stick--; //스틱 한개가 사라진다(다 짤림)
                result++; //사라진 스틱만큼 잘린개수 증가
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }*/

    /* 2022-06-30
     * 문제출저: 백준 17413번
     * 문제: 단어를 거꾸로출력하되 태그는 그대로 출력
     * 배울점: Stack 쓰지않고 index 증가시키면서 문자 확인
    static String str = "";
    static int index = 0;

    public static String tagString(){
        StringBuilder sb = new StringBuilder();

        //'>'만날때 까지 단어를 조립한다
        while(true){
            if(str.charAt(index) == '>'){
                sb.append(str.charAt(index));
                index++;
                return sb.toString();
            }
            else{
                sb.append(str.charAt(index));
                index++;
            }
        }
    }

    public static String wordString(){
        StringBuilder sb = new StringBuilder();

        //현재 인덱스부터 ' ' 또는 '<' 만나면 단어 끝
        while(true){
            //공백을 만난경우, 공백다음문자로 index 증가시키고 종료
            if(str.charAt(index) == ' '){
                index++;
                sb.reverse().append(" ");
                return sb.toString();
            }
            //태그를 만난경우, 바로 종료
            else if(str.charAt(index) == '<'){
                return sb.reverse().toString();
            }
            //문장이 끝난경우, 바로 종료
            else if(str.charAt(index) == '\n'){
                return sb.reverse().toString();
            }
            //단어를 조립
            else{
                sb.append(str.charAt(index));
                index++;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine() + "\n";
        StringBuilder sb = new StringBuilder();

        //모든 문자를 체크하면서
        while(true){

            char ch = str.charAt(index);
            String temp = "";

            //문자열의 마지막인 경우
            if(ch == '\n'){
                break;
            }
            //태그인경우
            else if(ch == '<'){
                temp = tagString();
                sb.append(temp);
            }
            //단어인경우
            else{
                temp = wordString();
                sb.append(temp);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }*/


    /* 2022-06-29
     * 문제출저: 백준 17413번
     * 문제: 단어를 거꾸로출력하되 태그는 그대로 출력
     * 배울점: 스택을 이용한 단어 뒤집기 로직을 가져옴
     *        '<'를 만났을때 스택에 있는 모든 문자를 거꾸로 출력하고 태그가 시작됨을 표시해 줘야 함
     *        태그가 시작되었으면 (isTag=true) '>' 만날때까지 출력만 해줌
     *
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine() + "\n";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        //모든 문자를 체크하면서
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '<'){
                //스택에 존재하는 단어를 꺼내면서 출력
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
                isTag = true;
            }

            //태그일경우 출력만하고 다음문자로 넘긴다
            if(isTag){
                sb.append(ch); //일단 태그단어 출력한다
                if(ch == '>') isTag = false; //태그닫힘을 만나면 종료
            }
            else{
                if(ch == ' ' || ch == '\n') { //띄어쓰기 또는 문장의 마지막 또는 태그 시작
                    //스택에 존재하는 단어를 꺼내면서 출력
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
                    sb.append( ch == ' ' ? " " : "" ); //띄어쓰기 붙여주기
                }else{
                    //스택에 단어를 넣기
                    stack.push(ch);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }*/

    /* 2022-06-26
     * 문제출저: 백준 1406번
     * 문제: 커서 이동, 문자 삭제, 문자 추가 가능한 에디터 구현
     * 배울점: LinkedList가 ArrayList에 비해 삽입,삭제가 유리하긴하지만 그 인덱스까지 찾아가는 시간자체가 늦으니 ListIterator를 사용해야 함
     *        ListIterator는 커서처럼 동작함 현재값이 없고 next 또는 previous만 보고 있음
     *        ListIterator 사용해도 시간초과가 나와서 Stack으로 구현
     *
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sentence = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String command = "";

        //첫번째 스택을 생성
        for(int i = 0; i < sentence.length(); i++){
            stack1.push(sentence.charAt(i));
        }

        //n회 반복하며 명령어를 수행
        while(n-- > 0){
            command = br.readLine();

            //커서를 왼쪽으로이동
            if(command.startsWith("L") && !stack1.empty())
                stack2.push(stack1.pop());

                //커서를 오른쪽으로 이동
            else if(command.startsWith("D") && !stack2.empty())
                stack1.push(stack2.pop());

                //문자를 삭제
            else if(command.startsWith("B") && !stack1.empty())
                stack1.pop();

                //문자를 추가
            else if(command.startsWith("P"))
                stack1.push(command.charAt(2));
        }

        StringBuilder sb = new StringBuilder();
        //스택을 합쳐 온전한 문장 만들기
        while(!stack2.empty())
            stack1.push(stack2.pop());
        //스트링빌더에 스택에 있는 문장 조립하기
        while(!stack1.empty())
            sb.append(stack1.pop());

        //거꾸로 출력
        bw.write(sb.reverse().toString());

        bw.flush();
        bw.close();
        br.close();
    }*/

    /* 2022-06-22
     * 문제출저: 백준 1874번
     * 문제: 1~N 까지 오름차순의 숫자를 스택에 넣었다가 빼는 방식으로 특정 수열을 만들 수 있는가
     * 배울점: Stack 클래스의 활용
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int index = 0;
        StringBuilder sb = new StringBuilder();

        //수열 입력
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        while(true){
            //push를 할까? => 스택이 비어있거나 피크랑 같지않으면
            if(stack.empty() || stack.peek()!=array[index]){
                if(num > n){ //push 해야하는데 더이상 숫자가 없음
                    System.out.println("NO");
                    break;
                }
                else {
                    stack.push(num++);
                    sb.append("+\n");
                }
            }

            //pop을 할까? => 스택의 피크랑 같으면
            else if(stack.peek()==array[index++])
                if(index == n){ //pop하려는데 arrray의 마지막임
                    sb.append("-\n");
                    System.out.println(sb.toString());
                    break;
                }else{
                    stack.pop();
                    sb.append("-\n");
                }
        }

        br.close();
    }*/


    /* 2022-06-21
     * 문제출저: 백준 9012번
     * 문제: 온전한 괄호문장인지 판단
     * 배울점: Stack 클래스의 활용
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = null;
        Stack<Character> stack = new Stack<>();

        //입력받은 n만큼 괄호를 판단해보자
        for(int i = 0; i < n; i++){
            stack.clear();
            str = br.readLine();

            //괄호 문장을 처음부터 끝까지 읽으면서 판단해보자
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '(')
                    stack.push('(');
                else if(str.charAt(j) == ')' && !stack.empty()){
                    stack.pop();
                }
                else if(str.charAt(j) == ')' && stack.empty()){
                    //VPS가 아닌걸로 판명 됨
                    bw.write("NO\n");
                    break;
                }

                //마지막 문자까지 판단완료 했을 때
                if(j == str.length() - 1)
                    bw.write( stack.empty() ? "YES\n" : "NO\n" ); //스택이 비어있으면 VPS로 판명, 남아있으면 VPS가 아닌걸로 판명
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }*/


    /* 2022-06-20
     * 문제출저: 백준 9093번
     * 문제: 문장받아서 단어만 거꾸로 출력하기
     * 배울점: StringBuilder의 reverse()으로 풀어도 됨, readLine()할때 개행을 붙여서 읽으면 판단하기 좋다
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sentence = null;
        String str = null;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = null;
        Stack<Character> stack = new Stack<>();

        //입력받은 N만큼 반복
        for(int i = 0; i < n; i++){
            //한 문장을 읽으면서 개행을 붙여준다.
            str = br.readLine() + "\n";

            //모든 문자를 체크하면서
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == ' ' || str.charAt(j) == '\n') { //띄어쓰기 또는 문장의 마지막
                    //스택에 존재하는 단어를 꺼내면서 출력
                    while(!stack.empty()){
                        bw.write(stack.pop());
                    }
                    bw.write( j == str.length()-1 ? "" : " " ); //띄어쓰기 붙여주기
                }else{
                    //스택에 단어를 넣기
                    stack.push(str.charAt(j));
                }
            }

            //한 문장 완료 후 개행 출력하기
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }*/


    /* 2022-06-20
     * 문제출저: 백준 10828번
     * 문제: 스택 기초
     * 배울점: 자바 Stack 클래스 기초 사용법, BufferedWriter 사용법
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        String str = null;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            str = br.readLine(); //한 줄 입력

            if(str.startsWith("push")){
                String[] strArray = str.split(" ");
                stack.push(Integer.parseInt(strArray[1]));
            }else if(str.equals("pop")){
                bw.write(stack.empty() ? "-1\n" : stack.pop() + "\n");
            }else if(str.equals("size")){
                bw.write(stack.size() + "\n");
            }else if(str.equals("empty")){
                bw.write(stack.empty() ? "1\n" : "0\n");
            }else if(str.equals("top")){
                bw.write(stack.empty() ? "-1\n" : stack.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }*/





