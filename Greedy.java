import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Greedy {
    /*
     * 2022-06-06
     * 문제출저: 동빈나 (이코테 2021 강의 몰아보기) 그리디&구현
     * 문제: 공포도 X 이면 한 그룹에 X명이 있어야 그룹을 만들수있다. 그룹의 최대 수를 구하라
     * 배울점: ArrayList 생성 및 정렬 방법
     */
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
    }



}
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




