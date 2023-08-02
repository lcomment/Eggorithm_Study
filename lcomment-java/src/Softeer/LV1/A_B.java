package Softeer.LV1;

import java.util.*;
import java.io.*;

public class A_B {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      sb.append("Case #").append(i + 1).append(": ").append(input[0] + input[1]).append("\n");
    }
    System.out.println(sb);
  }
}
