package Programmers.Level2;

public class Programmers_12900 {
    public int solution(int n) {
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2 ; i<=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1_000_000_007;
        }

        return dp[n];
    }
}
