import java.util.*;

public class BOJ_2632{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //입력
        int size = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();

        int[] a_pizza = new int[a];
        int max_a = 0;
        for(int i = 0; i < a; i++) {
            a_pizza[i] = scan.nextInt();
            max_a += a_pizza[i];
        }

        int[] b_pizza = new int[b];
        int max_b = 0;
        for(int i = 0; i < b; i++) {
            b_pizza[i] = scan.nextInt();
            max_b += b_pizza[i];
        }
        //입력 끝!

        int[] a_count = new int[Math.max(max_a, size) + 1];
        a_count[0] = 1;
        a_count[max_a] = 1;
        count(a_pizza, a_count, size);

        int[] b_count = new int[Math.max(max_b, size) + 1];
        b_count[0] = 1;
        b_count[max_b] = 1;
        count(b_pizza, b_count, size);

        int result = 0;
        for(int i = 0; i <= size; i++) {
            result += (a_count[i] * b_count[size - i]);
        }
        System.out.println(result);
    }

    public static void count(int[] pizza, int[] count, int size) {// 원으로 돌면서 순회
        for(int i = 0; i < pizza.length; i++) { //시작하는 피자의 인덱스
            int sum = 0;
            for(int j = 1; j < pizza.length; j++) { //선택하는 피자 조각의 개수
                int sum_j = pizza[(i + j) % pizza.length];  // 인덱스가 넘어가도 처음으로 돌아가기 위함
                if(sum + sum_j > size) break;
                sum += sum_j;
                count[sum]++;
            }
        }
    }
}