package BOJ.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2512 {
    static int N, M;
    static int[] seq;
    static int max = -1, result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = sToI(br.readLine());

        // 예산 요청의 합보다 국가예산이 많거나 같으면 예산 요청 중 max 출력 후 종료
        if(Arrays.stream(seq).sum() <= M) {
            System.out.println(Arrays.stream(seq).max().getAsInt());
            return;
        }

        Arrays.sort(seq);

        /* 예산은 1부터 예산 요청 MAX 까지 될 수 있음
         * 하지만 MAX 를 구하는 과정보다 이분탐색이 빠름
         * 따라서 최대값을 국가예산의 최대값인 10억으로 박음
         * (물론 입력 과정에서 stream 을 사용하지 않고 StringTokenizer 를 사용하면서
         *  MAX 값을 구해놓으면 좋겠지만, 그래봤자 10~20ms 차이라서 안함)
         */
        binarySearch(1, 1_000_000_000);
    }

    static void binarySearch(int left, int right) {
        int mid = (left + right) / 2;
        int total = calculate(mid);

        // 같은 곳에 방문했을 때는 result 가 예산 최댓값이기 때문에 출력 후 종료
        if(mid == result) {
            System.out.println(result);
            return;
        }

        // 예산을 넘어감 → 바로 재귀
        if(total > M) {
            binarySearch(left, mid);
        }
        // 예산 총액 최대값이면 max 와 result 갱신
        else {
            if(max < total) {
                total = max;
                result = mid;
            }
            binarySearch(mid, right);
        }
    }

    static int calculate(int money) {
        int total = 0;
        for(int n : seq){
            total += separateMoney(n, money);
        }
        return total;
    }

    static int separateMoney(int money, int budget) {
        return Math.min(money, budget);
    }

    static int sToI(String s){
        return Integer.parseInt(s);
    }
}
