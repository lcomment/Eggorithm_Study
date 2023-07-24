package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10844 {

  static final long MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[N + 1][10];

    // init
    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) {
          dp[i][0] = dp[i - 1][1] % MOD;
        } else if (j == 9) {
          dp[i][9] = dp[i - 1][8] % MOD;
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
      }
    }

    System.out.println(Arrays.stream(dp[N]).sum() % MOD);
  }

}
