package Softeer.LV2;

import java.util.*;
import java.io.*;
public class 전광판 {

  static int[][] map = {
      {1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 0, 0, 0, 0},
      {1, 1, 0, 1, 1, 0, 1},
      {1, 1, 1, 1, 0, 0, 1},
      {0, 1, 1, 0, 0, 1, 1},
      {1, 0, 1, 1, 0, 1, 1},
      {1, 0, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 1, 0},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 0, 1, 1}
  };

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int[] A = new int[5];
      int[] B = new int[5];

      init(A, input[0]);
      init(B, input[1]);

      int result = 0;
      for (int i = 0; i < 5; i++) {
        if (A[i] == B[i]) {
          continue;
        }

        if (A[i] == -1) {
          result += count(B[i]);
        } else if (B[i] == -1) {
          result += count(A[i]);
        } else {
          result += count(A[i], B[i]);
        }
      }
      System.out.println(result);
    }
  }

  private static void init(int[] arr, int num) {
    Arrays.fill(arr, -1);
    for (int i = 0; i < 5 && num != 0; i++) {
      arr[i] = num % 10;
      num /= 10;
    }
  }

  private static int count(int n) {
    int cnt = 0;
    for (int i = 0; i < 7; i++) {
      cnt += map[n][i];
    }
    return cnt;
  }

  private static int count(int a, int b) {
    int cnt = 0;

    for (int i = 0; i < 7; i++) {
      if (map[a][i] != map[b][i]) {
        cnt++;
      }
    }
    return cnt;
  }
}
