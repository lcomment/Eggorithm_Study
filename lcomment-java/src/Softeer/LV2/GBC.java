package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GBC {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    int N = input[0];
    int M = input[1];

    List<Part> limitList = new ArrayList<>();
    List<Part> fastList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      input = sToIntArray(br.readLine());

      if (limitList.isEmpty()) {
        limitList.add(new Part(input[0], input[1]));
      } else {
        limitList.add(new Part(input[0] + limitList.get(i - 1).end, input[1]));
      }
    }
    for (int i = 0; i < M; i++) {
      input = sToIntArray(br.readLine());

      if (fastList.isEmpty()) {
        fastList.add(new Part(input[0], input[1]));
      } else {
        fastList.add(new Part(input[0] + fastList.get(i - 1).end, input[1]));
      }
    }

    int idxL = 0;
    int idxF = 0;
    int pos = 1;
    int max = 0;

    while (pos <= 100) {
      Part limit = limitList.get(idxL);
      Part fast = fastList.get(idxF);

      max = Math.max(fast.fast - limit.fast, max);

      pos++;

      if(limit.end < pos) {
        idxL++;
      }
      if(fast.end < pos) {
        idxF++;
      }
    }
    System.out.println(max);
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  static class Part {

    int end, fast;

    Part(int end, int fast) {
      this.end = end;
      this.fast = fast;
    }
  }
}
