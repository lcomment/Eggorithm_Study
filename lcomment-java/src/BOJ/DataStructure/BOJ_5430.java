package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class BOJ_5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = stoi(br.readLine());
    StringBuilder sb = new StringBuilder();

    LOOP:
    while (T-- > 0) {
      char[] p = br.readLine().toCharArray();
      int N = stoi(br.readLine());
      Deque<Integer> deque = sToDeque(br.readLine());

      // true: 앞에서, false: 뒤에서
      boolean flag = true;
      for(char cmd : p) {
        if(cmd == 'R') {
          flag = !flag;
        }
        else if(cmd == 'D' && deque.isEmpty()) {
          sb.append("error").append("\n");
          continue LOOP;
        }
        else if(cmd == 'D' && flag) {
          deque.removeFirst();
        }
        else if(cmd == 'D' && !flag) {
          deque.removeLast();
        }
      } // for

      int[] result = new int[deque.size()];
      for(int i=0 ; i<result.length ; i++) {
        if(flag) {
          result[i] = deque.pollFirst();
        } else {
          result[i] = deque.pollLast();
        }
      }

      String print = Arrays.toString(result).replaceAll(" ", "");
      sb.append(print).append("\n");
    } // while

    System.out.println(sb);
  }

  private static Deque<Integer> sToDeque(String s) {
    s = s.replace("[", "").replace("]", "");

    if(s.length() == 0) {
      return new ArrayDeque<>();
    }

    Deque<Integer> deque = new ArrayDeque<>();
    for(String n : s.split(",")) {
      deque.offer(Integer.parseInt(n));
    }
    return deque;
  }

  private static int stoi(String s) {
    return Integer.parseInt(s);
  }
}
