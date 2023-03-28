import java.util.*;
import java.io.*;

public class BOJ_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {
            dp[i] = 1;
            if (dp[i-1] == 1 && dp[i-3] == 1 && dp[i-4] == 1) {
                dp[i] = 2;
            }
        }
        if (dp[n] == 1) {
            System.out.print("SK");
        } else {
            System.out.print("CY");
        }
    }
}