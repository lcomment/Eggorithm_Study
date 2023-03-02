import java.io.*;
import java.util.*;

public class BOJ_11057 {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];

        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i=1; i<=n; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=9; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
            }
        }

        int result = 0;
        for (int i=0; i<=9; i++) {
            result += dp[n][i];
        }

        System.out.println(result % 10007);
    }
}
