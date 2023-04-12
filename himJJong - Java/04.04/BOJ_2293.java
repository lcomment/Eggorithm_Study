import java.io.*;
import java.util.*;
public class BOJ_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];

        for (int t = 0; t < n; t++) {
            int coin = Integer.parseInt(br.readLine());

            for (int i = 1; i <= k; i++) {

                if (i - coin > 0) {
                    dp[i] = dp[i] + dp[i-coin];
                }
                else if (i - coin == 0) {
                    dp[i]++;
                }

            }
        }

        System.out.print(dp[k]);
    }
}