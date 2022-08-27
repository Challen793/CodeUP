public class TwoPointer {

}

    /*
     * 2022-08-28
     * 문제출저: 백준 2003번 문제
     * 문제: 수열에서 특정 숫자를 만족하는 연속되는 부분합 구하기
     * 배울점: for문 안에 while문을 이해하고 작성하는데 시간을 많이 소비함
     *        부분합과 목표한 값을 비교하여 3가지 경우에 대해서 생각해 볼것
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int target = Integer.parseInt(str[1]);
        int[] arr = new int[N];

        //수열 입력 받기
        str = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(str[i]);

        int start = 0; //시작점
        int end = -1; //끝점
        int count = 0; //target과 일치하는 개수
        int sum = 0; //부분합

        //start를 처음부터 끝까지 확인
        for(start = 0; start < N; start++){
         	//end를 증가시키며 확인해 본다.
            while(true){
                if(sum < target) //부분수열의 범위 확장 필요
                	end++;
                else{ //카운트 후 부분수열의 범위 축소 필요
                    count = (sum == target) ? count+1 : count;
                    break;
                }

                //부분합을 계산하기
                if(end < N)
                	sum += arr[end];
                else
                    break;
            }

            //start 증가하기 전에 부분합 다시 계산
            sum -= arr[start];
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/
