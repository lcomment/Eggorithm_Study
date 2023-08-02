package Softeer.LV3;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class 성적_평균 {

  static int N, K;
  static int[] seq;

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    N = input[0];
    K = input[1];
    seq = sToIntArray(br.readLine());

    while (K-- > 0) {
      input = sToIntArray(br.readLine());

      System.out.printf("%.02f \n",
          Math.round(sum(input[0], input[1]) / (double) (input[1] - input[0] + 1) * 100)
              / (double) 100);
    }
  }

  static double sum(int start, int end) {
    int result = 0;
    for (int i = start - 1; i < end; i++) {
      result += seq[i];
    }
    return result;
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
