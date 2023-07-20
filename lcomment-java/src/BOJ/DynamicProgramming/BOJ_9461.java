package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];

        dp[1] = dp[2] = 1;
        for(int i=3 ; i<101 ; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        int T = stoi(br.readLine());

        while(T-- > 0) {
            System.out.println(dp[stoi(br.readLine())]);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
