package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 우물_안_개구리 {

  static int N, M;
  static int[] weights;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    N = input[0];
    M = input[1];
    weights = sToIntArray(br.readLine());

    int[] bestList = new int[N + 1];
    Arrays.fill(bestList, 1);
    bestList[0] = 0;

    for (int i = 0; i < M; i++) {
      input = sToIntArray(br.readLine());

      if (weights[input[0] - 1] > weights[input[1] - 1]) {
        bestList[input[1]] = 0;
      } else if (weights[input[0]- 1] < weights[input[1] - 1]) {
        bestList[input[0]] = 0;
      } else {
        bestList[input[0]] = bestList[input[1]] = 0;
      }
    }

    int result = 0;
    for (int i : bestList) {
      if (i == 1) {
        result++;
      }
    }

    System.out.println(result);
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
