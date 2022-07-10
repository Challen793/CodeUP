import java.util.ArrayList;
import java.util.Comparator;

public class myUtils {

    /* String → 16진수 정수로 해석 */
    public int StringToHex(String str){
        return Integer.valueOf(str, 16);
    }

    /* 정수를 16진수로 해석하여 → String 변환 */
    public String StringToHex(int hex){
        return Integer.toHexString(hex);
    }

    /* char → int 변환 */
    public int CharToInt(char ch){
        return ch - '0';
        //다른 방법 return Character.getNumericValue(ch);
    }

    /* String을 뒤집기 */
    public String reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /* 자연수 a, b를 입력 받고, a보다 작은 값 중에서,
    * b와 나누어떨어지기 위한 가장 가까운 수를 찾는다. */
    public int nearDisibleNumber(int a, int b){
        return (a * b) / b;
    }

    /* int형 2차원 배열에서 좌표,길이,높이 입력 받아 값을 합산 */
    public static int sum(int[][] matrix, int start_i, int start_j, int width, int height){
        int sum = 0;

        for( int i = start_i; i < start_i + height; i++ ){
            for( int j = start_j; j < start_j + width; j++){
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    /* 2차원 배열 출력하기 */
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(j == matrix[i].length - 1 ? "" : " ");
            }
            System.out.print(i == matrix.length - 1 ? "" : "\n");
        }
    }

    /* ArrayList 정렬 */
    public ArrayList<Integer> OrderByArrayList(ArrayList<Integer> arrayList, int option){
        //오름차순 정렬
        if(option == 0){
            arrayList.sort(Comparator.naturalOrder());                 //ArrayList를 사용한 오름차순 정렬
            //Collections.sort(arrayList);                             //Collections를 사용한 오름차순 정렬
            return arrayList;
        }

        //내림차순 정렬
        if(option == 1){
            arrayList.sort(Comparator.reverseOrder());                 //ArrayList를 사용한 내림차순 정렬
            //Collections.sort(arrayList, Collections.reverseOrder()); //Collections를 사용한 내림차순 정렬
            return arrayList;
        }

        return null;
    }
}
