package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[30][30];
        init(dp);

        for(int i=2 ; i<30 ; i++) {
            for(int j=i ; j<30 ; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        int T = stoi(br.readLine());
        while(T-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(dp[input[0]][input[1]]);
        }

    }

    private static void init(long[][] dp) {
        for(int i=1 ; i<30 ; i++) {
            dp[1][i] = i;
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
