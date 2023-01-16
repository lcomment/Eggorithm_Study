import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2156 {
    static int[] arr;
    static int[] dp;
    static int maxValue = 0;
    public static void main(String[] args) throws Exception {
        // 첫째줄에 포도주 잔의 개수 n개 주어짐
        // 1 <= n <= 10,000
        // 둘째줄부터 n + 1까지 포도주 양 주어짐
        // 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(dynamicProgramming(N));
    }

    public static int dynamicProgramming(int N) {
        for(int i = 1; i <= N; i++) {
            if(i < 3) {
                dp[i] = arr[i] + dp[i - 1];
            }
            if(i >= 2) {
                dp[i] = Math.max(dp[i - 2] + arr[i], arr[i - 1] + arr[i]);
            }
            if(i >= 3) {
                dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], Math.max(dp[i - 1], dp[i]));
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }
}