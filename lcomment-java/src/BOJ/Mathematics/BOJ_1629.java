package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1629 {

  static long C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] input = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

    long A, B;
    A = input[0];
    B = input[1];
    C = input[2];

    System.out.println(pow(A, B));
  }

  private static long pow(long A, long ex) {
    if (ex == 1) {
      return A % C;
    }

    long half = pow(A, ex / 2);

    if (ex % 2 == 1) {
      return (half * half % C) * A % C;
    }
    return half * half % C;
  }
}
