package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_1874 {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = stoi(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int num = 1;

    StringBuilder sb = new StringBuilder();
    while (N-- > 0) {
      int input = stoi(br.readLine());

      if (input > num) {
        for (int i = num + 1; i <= input; i++) {
          stack.push(i);
          sb.append('+').append('\n');  // + 를 저장한다.
        }
        num = input;
      } else if (stack.peek() != input) {
        System.out.println("NO");
        return;
      }
      stack.pop();
      sb.append('-').append('\n');
    }

    System.out.println(sb);
  }

  private static int stoi(String s) {
    return Integer.parseInt(s);
  }
}
