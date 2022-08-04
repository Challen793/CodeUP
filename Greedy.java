import java.io.*;
import java.util.ArrayList;

public class Greedy {

}

     /*
     * 2022-08-05
     * 문제출저: 코드업 11047번
     * 문제: 동전문제 혹은 거스름돈 문제
     * 배울점: 그리디의 기초 문제인듯
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int money = 0;

        for(int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));

        //큰 동전부터 최대로 넣기
        for(int i = N-1; i >=0; i--){
            int token = list.get(i);

            count += K / token; //현재 동전으로 최대 몇개까지 제출 가능한지
            K %= token; //현재 동전으로 제출 후 남은 값

            if(K == 0)
                break;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }*/


    /*
     * 2022-06-15
     * 문제출저: 코드업 3120문제
     * 문제: 리모컨 최소한으로 눌러서 원하는 온도 맞추기
     * 배울점: 목표치에 근접해야 한다 → 거리(절대값)를 판단해야 한다
     *        리모컨에서 누를 수 있는 버튼들을 int 배열로 미리 선언해 둔다
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int[] select = {1, 5, 10, -1, -5, -10}; //리모컨 선택할 수 있는 숫자
        int count = 0; //리모컨 누른 횟수

        int distance = 0; //이동 후 목표와의 거리
        int minDistance = 0; //거리 중 최소값
        int min = 0; //거리 최소값의 인덱스

        while(true)
        {
            if(a == b) //목표에 도달
                break;

            minDistance = Math.abs(a - b + select[0]);
            min = 0;
            for(int i = 1; i < 6; i++){
                distance = Math.abs(a - b + select[i]);
                if(distance < minDistance){ //거리 제일 작은게 뭔지
                    minDistance = distance;
                    min = i;
                }
            }

            a += select[min]; //리모컨 누르기
            count++; //리모컨 누르기
        }

        System.out.println(count);
    }*/

    /*
     * 2022-06-15
     * 문제출저: 코드업 3321문제
     * 문제: 피자에 토핑을 선택할때 달러당 칼로리 수치가 최대가 되는 경우 찾기
     * 배울점: 탐욕 알고리즘 해법으로 잘 찾아감
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(br.readLine());
        ArrayList<Integer> topping = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) { topping.add(Integer.parseInt(br.readLine())); }

        double bestPizza = 0; //최고의 달러당 칼로리
        double temp = 0; //달러당 칼로리
        double calSum = c; //칼로리 합계
        double dollar = a; //달러

        //토핑을 칼로리 순서대로 내림차순 정렬
        topping.sort(Comparator.reverseOrder());

        //토핑을 순회하면서
        for(int i = 0; i < n; i++){
            calSum += topping.get(i); //칼로리 합치기
            dollar += b; //달러 합치기
            temp = calSum / dollar;
            if(temp > bestPizza )
                bestPizza = temp;
        }

        System.out.println((int)bestPizza);
    }*/


    /*
     * 2022-06-14
     * 문제출저: 코드업 3301문제
     * 문제: 화폐 최소 개수로 거스름돈 거슬러 주기
     * 배울점: 코드 깔끔하게 잘 짠거 같음
     public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int next = Integer.parseInt(br.readLine());
        int result = 0;
        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int i = 0; i < 8; i++){
            if(next >= money[i]) { //현재 화폐로 거슬러줄 수 있는지 판단
                result += next / money[i]; //거스름돈 개수 만큼 증가
                next = next % money[i]; //거슬러주고 남은 돈
            }
            if(next == 0) break; //남은돈이 0원이면 종료
        }
        System.out.println(result);
    }*/


    /*
     * 2022-06-07
     * 문제출저: 동빈나 (이코테 2021 강의 몰아보기) 그리디&구현
     * 문제: 공포도 X 이면 한 그룹에 X명이 있어야 그룹을 만들수있다. 그룹의 최대 수를 구하라
     * 배울점: ArrayList 생성 및 정렬 방법
     public static void main(String args[]) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            ArrayList<Integer> list = new ArrayList<Integer>(n);

            int count = 0; //모험가 수
            int group = 0; //결성된 그룹 수

            //ArrayList에 입력값 채워넣고 정렬
            for(int i = 0; i < n; i++){
                list.add(Integer.parseInt(str[i]));
            }
            list.sort(Comparator.naturalOrder());                 //ArrayList를 사용한 오름차순 정렬
            //list.sort(Comparator.reverseOrder());               //ArrayList를 사용한 내림차순 정렬
            //Collections.sort(list);                             //Collections를 사용한 오름차순 정렬
            //Collections.sort(list, Collections.reverseOrder()); //Collections를 사용한 내림차순 정렬

            for(int i = 0; i < n; i++){
                count++; //모험가 수 증가
                if(count >= list.get(i)){ //모험가수랑 현재의 공포도가 같으면
                    group++;   //그룹 결성
                    count = 0; //모험가 수 초기화
                }
            }
        }
    }*/


    /*
    * 2022-06-06
    * 문제출저: 동빈나 (이코테 2021 강의 몰아보기) 그리디&구현
    * 문제: 문자열로 제공되는 숫자들을 앞에서부터 곱하기 혹은 더하기 연산하여 최대값 구하기
    * 배울점: 0이나 1이 곱해지면 덧셈보다 손해를 보니까 덧셈을 진행해야한다.
    *        단, 현재값(result)와 다음값(next) 모두 고려해야 한다.
    public static void main(String args[]) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int result = 0;
            int next = 0;

            for(int i = 0; i < str.length(); i++){
                next = str.charAt(i) - '0';
                if(i == 0 || result < 1 || next < 1 ) //덧셈을 해야하는 경우
                    result += next;
                else
                    result *= next;
            }

            System.out.println(result);
        }
    }
    }*/


    /*
    * 2022-06-06
    * 문제출저: 동빈나 (이코테 2021 강의 몰아보기) 그리디&구현
    * 문제: 자연수 N은 N-1 또는 N/K(K로 나누어질때) 가능하며 N이 1이 될때 까지의 최소 실행횟수 구하기
    * 배울점: 가장 가까이 나누어 떨어지는 수 구하는 기법
    public static void main(String args[]) throws IOException {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int result = 0;
            int nearNumber = 0;

            while (true) {
                //n<k 가 되면 nearNumber가 0으로 나옴
                if(n < k)
                    break;

                //가장 가까이 나누어 떨어지는 수 구하기
                nearNumber = (n / k) * k;

                //뺄셈 횟수 적립
                result += n - nearNumber;

                //나눗셈 수행
                n = nearNumber / k;

                //나눗셈 횟수 적립
                result++;
            }

            //n이 1이 될때까지 뺄셈 횟수 적립
            result += (n - 1);

            System.out.println(result);
        }
    }*/




