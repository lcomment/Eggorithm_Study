import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1535{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int limit = 99;
        int[][] dp = new int[n+1][limit+1];
        int[] health = new int[n+1];
        int[] happy = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            health[i] = Integer.parseInt(st.nextToken());
            happy[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= limit; j++) {
                if (health[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-health[i]]+happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][limit]);
    }
}