package Softeer.LV1;

import java.util.*;
import java.io.*;
public class 근무시간 {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int result = 0;
    for (int i = 0; i < 5; i++) {
      result += calculateWorkingTime(br.readLine().split(" "));
    }

    System.out.println(result);
  }

  private static int calculateWorkingTime(String[] times) {
    int[] start = Arrays.stream(times[0].split(":")).mapToInt(Integer::parseInt).toArray();
    int[] end = Arrays.stream(times[1].split(":")).mapToInt(Integer::parseInt).toArray();

    if (start[0] == end[0]) {
      return end[1] - start[1];
    }

    if (start[1] == 0) {
      return 60 * (end[0] - start[0]) + end[1];
    }
    return 60 * (end[0] - start[0] - 1) + (60 - start[1]) + end[1];
  }
}
