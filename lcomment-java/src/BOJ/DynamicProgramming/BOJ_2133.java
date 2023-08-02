package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    if (N % 2 == 1) {
      System.out.println(0);
      return;
    }

    long[] arr = new long[N + 1];
    arr[0] = 1;
    arr[2] = 3;

    for (int i = 4; i <= N; i += 2) {
      arr[i] = 4 * arr[i - 2] - arr[i - 4];
    }

    System.out.println(arr[N]);
  }
}
