package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지도_자동_구축 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1];
    dp[0] = 2;

    for (int i = 1; i <= N; i++) {
      dp[i] = 2 * dp[i - 1] - 1;
    }

    System.out.println((int) Math.pow(dp[N], 2));
  }
}
