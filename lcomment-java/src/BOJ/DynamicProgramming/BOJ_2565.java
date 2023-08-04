package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2565 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Line[] list = new Line[N];
    for (int i = 0; i < N; i++) {
      list[i] = new Line(sToIntArray(br.readLine()));
    }

    Arrays.sort(list);

    long[] dp = new long[N];
    for (int i = 0; i < N; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if(list[i].b > list[j].b) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    long result = 0;
    for(int i=0 ; i<N ; i++) {
      result = Math.max(result, dp[i]);
    }

    System.out.println(N - result);
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  static class Line implements Comparable<Line> {

    int a, b;

    Line(int[] input) {
      this.a = input[0];
      this.b = input[1];
    }

    @Override
    public int compareTo(Line o) {
      return this.a - o.a;
    }
  }
}
