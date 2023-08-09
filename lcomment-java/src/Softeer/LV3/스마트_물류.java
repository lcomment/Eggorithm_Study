package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스마트_물류 {

  static int N, K, count = 0;
  static char[] seq;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    N = stoi(input[0]);
    K = stoi(input[1]);

    seq = br.readLine().toCharArray();

    boolean[] picks = new boolean[N];
    if (seq[0] == 'P') {
      for (int j = 1; j <= K && j < N; j++) {
        if (seq[j] == 'H' && !picks[j]) {
          picks[j] = true;
          count++;
          break;
        }
      }
    }

    for (int i = 1; i < N; i++) {
      if (seq[i] == 'P') {
        picks[i] = true;
        int start = Math.max(i - K, 0);
        int end = i + K >= N ? N - 1 : i + K;

        for (int j = start; j <= end; j++) {
          if (seq[j] == 'H' && !picks[j]) {
            picks[j] = true;
            count++;
            break;
          }
        }
      }
    }
    System.out.println(count);
  }

  static int stoi(String s) {
    return Integer.parseInt(s);
  }
}
