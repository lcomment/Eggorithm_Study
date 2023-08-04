package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7579 {

  static int N, M;
  static App[] apps;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    N = input[0];
    M = input[1];
    apps = new App[N];

    int[] memories = sToIntArray(br.readLine());
    int[] costs = sToIntArray(br.readLine());

    for (int i = 0; i < N; i++) {
      apps[i] = new App(memories[i], costs[i]);
    }
    long[] dp = new long[10001];

    for (int i = 0; i < N; i++) {
      App app = apps[i];

      for (int j = 10000; j >= app.cost; j--) {
        dp[j] = Math.max(dp[j - app.cost] + app.memory, dp[j]);
      }
    }

    for (int i = 0; i < 10001; i++) {
      if (dp[i] >= M) {
        System.out.println(i);
        break;
      }
    }
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  static class App {

    int memory, cost;

    App(int memory, int cost) {
      this.memory = memory;
      this.cost = cost;
    }
  }

}
