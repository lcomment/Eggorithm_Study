package Softeer.LV1;

import java.util.*;
import java.io.*;

public class 주행거리_비교하기 {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    System.out.println(input[0] >= input[1] ? (input[0] == input[1] ? "same" : "A") : "B");
  }
}
