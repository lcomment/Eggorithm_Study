import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15989 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];

        dp[1][1] = dp[2][1] = dp[3][1] = dp[2][2] = dp[3][2] = dp[3][3] = 1;

        for(int i=4; i<=10000; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            System.out.println(dp[val][1] + dp[val][2] + dp[val][3]);
        }
    }
}
