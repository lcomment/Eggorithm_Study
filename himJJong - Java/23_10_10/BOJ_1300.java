import java.util.Scanner;

public class BOJ_1300 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        // x는 lo <= x <= hi 의 범위를 갖는다.
        long lo = 1;
        long hi = K;

        // lower-bound
        while(lo <= hi) {

            long mid = (lo + hi) / 2;	// 임의의 x(mid)를 중간 값으로 잡는다.
            long count = 0;

            /*
             *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
             *  누적 합을 구한다.
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            // count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻
            if(K <= count) {
                hi = mid-1;
            }
            else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}