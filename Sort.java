public class Sort {

}

    /*
     * 2022-08-07
     * 문제출저: 동빈나 정렬 강의
     * 문제: N개의 원소를 가진 A배열과 B배열을 K번 스왑 가능할때, A의 합이 가장 커지는 경우 찾기
     * 배울점:
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();

        //리스트A 입력받기
        str = br.readLine().split(" ");
        for(int i = 0; i < str.length; i++)
            listA.add(Integer.parseInt(str[i]));

        //리스트B 입력받기
        str = br.readLine().split(" ");
        for(int i = 0; i < str.length; i++)
            listB.add(Integer.parseInt(str[i]));

        //각각 오름차순, 내림차순 정렬
        listA.sort(Comparator.naturalOrder());
        listB.sort(Comparator.reverseOrder());

        //K만큼 스왑 시도
        for(int i = 0; i < K; i++){
            int A = listA.get(i);
            int B = listB.get(i);

            if(A >= B)
                break;

            //바꿔주기
            listA.set(i, B);
            listB.set(i, A);
        }

        //최대값 구하기
        int max = 0;
        for(int i = 0; i < N; i++)
            max += listA.get(i);

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }*/
