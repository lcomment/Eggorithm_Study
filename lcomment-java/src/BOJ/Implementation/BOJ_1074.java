package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1074 {

  static int N, R, C;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    N = input[0];
    R = input[1];
    C = input[2];

    find((int) Math.pow(2, N), R, C);
    System.out.println(count);
  }

  private static void find(int size, int r, int c) {
    if (size == 1) {
      return;
    }

    // 2사분면
    if (r < size / 2 && c < size / 2) {
      find(size / 2, r, c);
    }
    // 1사분면
    else if (r < size / 2 && c >= size / 2) {
      count += size * size / 4;
      find(size / 2, r, c - size / 2);
    }
    // 3사분면
    else if (r >= size / 2 && c < size / 2) {
      count += (size * size / 4) * 2;
      find(size / 2, r - size / 2, c);
    }
    // 4사분면
    else {
      count += (size * size / 4) * 3;
      find(size / 2, r - size / 2, c - size / 2);
    }
  }
}
