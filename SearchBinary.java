import java.io.*;
import java.util.Arrays;

public class SearchBinary {

}

    /*
     * 2022-08-12
     * 문제출저: 동빈나 이진탐색 강의
     * 문제: 정렬된 수열에서 입력된 X의 개수를 찾기
     * 배울점: 목표한 숫자를 찾기 위해 이진탐색을 수행하며 찾으면 끝나는게 아니라 더이상 이진탐색을 할 수 없을때까지 수행한다.
     *        다만 목표한 숫자를 찾았을 때 왼쪽으로갈지 오른쪽으로갈지만 판단해주면 된다.
    public static int binarySearch(int[] arr, int target, boolean firstSearch){
        int result = -1;
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            //중간점 구하기
            int mid = (start + end) / 2;
            //오른쪽으로 탐색 수행
            if(arr[mid] < target)
                start = mid + 1;
                //왼쪽으로 탐색 수행
            else if(arr[mid] > target)
                end = mid - 1;
                //타겟을 찾은 경우
            else if(arr[mid] == target){
                result = mid;
                if(firstSearch) //첫 등장을 찾기 위해 왼쪽으로 더 탐색
                    end = mid - 1;
                else //마지막 등장을 찾기 위해 오른쪽으로 더 탐색
                    start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = {1,2,2,2,3,3,3,4,4,4,4,5,6,6,7,7,7};

        int target = Integer.parseInt(br.readLine());
        int firstIndex = binarySearch(arr, target, true);
        int lastIndex = binarySearch(arr, target, false);

        System.out.println(firstIndex + " " + lastIndex);
    }*/





    /*
     * 2022-08-08
     * 문제출저: 동빈나 이진탐색 강의
     * 문제: 서로다른 N개의 길이의 떡을 H높이의 커팅기로 잘랐을 때 적어도 M만큼은 고객에게 줘야한다. 이떄 H의 최대값 구하기
     * 배울점: 이진탐색의 종료조건은 start가 end를 넘어설 때이다.
    static int[] ricecake;

    public static int cutting(int mid){
        int sum = 0;

        //mid로 컷팅했을때 떡의 길이를 구한다.
        for(int i = 0; i < ricecake.length; i++){
            if(ricecake[i] > mid) //잘려나오는게 있음
                sum += ricecake[i] - mid;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int H = 0;
        int max = 0;
        str = br.readLine().split(" ");
        ricecake = new int[N];

        //떡의 길이를 입력받고 최대 길이를 저장
        for(int i = 0; i < N; i++){
            ricecake[i] = Integer.parseInt(str[i]);
            max = max < ricecake[i] ? ricecake[i] : max;
        }


        int start = 0;
        int end = max;
        int mid = 0;
        long result = 0;

        while(start <= end){

            mid = (start + end) / 2;

            //컷팅해보기
            result = cutting(mid);

            if(result > M){
                H = mid; //가능한 경우이므로 우선 저장해둔다.
                start = mid + 1; //위쪽 범위를 탐색 → H를 늘려보기
            }
            else if(result < M)
                end = mid - 1; //아래쪽 범위를 탐색 → H를 줄여보기
            else if(result == M){
                H = mid; //가능한 경우이므로 우선 저장해둔다.
                break;
            }
        }

        bw.write(H + "");
        bw.flush();
        bw.close();
        br.close();
    }*/