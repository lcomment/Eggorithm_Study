import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(dynamicProgramming(N));
    }

    public static int dynamicProgramming(int N) {
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + dp[1]);
            for(int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[N];
    }
}
