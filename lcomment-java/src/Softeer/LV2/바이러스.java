package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 바이러스 {
  private static final long MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int K = input[0];
    int P = input[1];
    int N = input[2];

    long[] dp = new long[N + 1];
    dp[0] = K;
    for (int sec = 1; sec <= N; sec++) {
      dp[sec] = dp[sec-1] * P % MOD;
    }
    System.out.println(dp[N]);
  }
}
