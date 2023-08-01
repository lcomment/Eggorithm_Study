package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2981 {

  static int N;
  static int[] seq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = stoi(br.readLine());
    seq = new int[N];
    for (int i = 0; i < N; i++) {
      seq[i] = stoi(br.readLine());
    }
    Arrays.sort(seq);

    int save = seq[1] - seq[0];

    for (int i = 2; i < N; i++) {
      save = gcd(save, seq[i] - seq[i - 1]);
    }

    for (int i = 2; i <= save; i++) {
      if (save % i == 0) {
        System.out.print(i + " ");
      }
    }
  }

  private static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  private static int stoi(String s) {
    return Integer.parseInt(s);
  }
}
