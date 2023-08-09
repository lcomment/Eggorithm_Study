package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 징검다리 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] dp = new int[N];

    Arrays.fill(dp, 1);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        if (seq[j] < seq[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    } // for_i

    int result = 0;
    for(int i=0 ; i<N ; i++)
      result = Math.max(result, dp[i]);

    System.out.println(result);
  }
}
