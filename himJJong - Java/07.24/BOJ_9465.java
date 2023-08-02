import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T -- >0){

            int n = Integer.parseInt(br.readLine());

            int[][] data = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    data[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = data[0][1];
            dp[1][1] = data[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + data[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + data[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}
