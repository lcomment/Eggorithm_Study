package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[15][15];

        init(dp);

        for(int i=1 ; i<15 ; i++) {
            for(int j=1 ; j<15 ; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        int T = stoi(br.readLine());
        while(T-- > 0) {
            int k = stoi(br.readLine());
            int n = stoi(br.readLine());

            System.out.println(dp[k][n]);
        }
    }

    private static void init(int[][] dp) {
        for(int i=1 ; i<15 ; i++) {
            dp[0][i] = i;
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
