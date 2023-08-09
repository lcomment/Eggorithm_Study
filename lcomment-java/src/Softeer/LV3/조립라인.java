package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 조립라인 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long[][] dp = new long[N+1][2];

    int[] input = sToIntArray(br.readLine());
    dp[1][0] = input[0];
    dp[1][1] = input[1];

    for(int i=2 ; i<=N ; i++) {
      int ai = input[2];
      int bi = input[3];
      input = sToIntArray(br.readLine());

      dp[i][0] = Math.min(dp[i-1][0] , dp[i-1][1] + bi) + input[0];
      dp[i][1] = Math.min(dp[i-1][1] , dp[i-1][0] + ai) + input[1];
    }
    System.out.println(Math.min(dp[N][0], dp[N][1]));
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
