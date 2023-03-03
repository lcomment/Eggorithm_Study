package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1563 {
    static final int div = 1_000_000;
    static int N;
    static long result = 0;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        dp = new long[N+1][2][3];

        dp[1][0][0] = 1; // 지각 0, 결석 0연속
        dp[1][1][0] = 1; // 지각 1, 결석 0연속
        dp[1][0][1] = 1; // 지각 0, 결석 1연속

        for(int day=2; day<=N ; day++) {
            dp[day][0][0] = (dp[day-1][0][0] + dp[day-1][0][1] + dp[day-1][0][2]) % div;

            dp[day][1][0] = (dp[day-1][0][0] + dp[day-1][0][1] + dp[day-1][0][2]
                    + dp[day-1][1][0] + dp[day-1][1][1] + dp[day-1][1][2]) % div;
            dp[day][1][1] = dp[day-1][1][0] % div;
            dp[day][1][2] = dp[day-1][1][1] % div;

            dp[day][0][1] = dp[day-1][0][0] % div;
            dp[day][0][2] = dp[day-1][0][1] % div;
        }

        calculateResult();
        System.out.println(result);
    }

    private static void calculateResult() {
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                result += dp[N][i][j];
                result %= div;
            }
        }
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
