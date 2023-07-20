package Programmers.Level2;

public class Programmers_12902 {
    private static final int MOD = 1_000_000_007;
    
    public int solution(int n) {
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4 ; i<=n ; i+=2) {
            dp[i] = (4 * dp[i-2] % MOD - dp[i-4] % MOD) + MOD;
            dp[i] %= MOD;
        }

        return (int)dp[n];
    }
}
