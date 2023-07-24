package BOJ.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_15961 {

  static int N, d, k, c;
  static int[] sushiList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    init(br.readLine());
    sushiList = new int[N];
    for (int i = 0; i < N; i++) {
      sushiList[i] = stoi(br.readLine());
    }

    int start = 0;
    int end = k - 1;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(c, 1);

    for (int i = 0; i <= end; i++) {
      putOrIncrease(map, sushiList[i]);
    }

    int max = map.size();

    do {
      map.replace(sushiList[start], map.get(sushiList[start]) - 1);
      if(map.get(sushiList[start]) == 0) map.remove(sushiList[start]);

      start = getNextIndex(start);
      end = getNextIndex(end);

      putOrIncrease(map, sushiList[end]);

      max = Math.max(max, map.size());
    } while (start != 0);

    System.out.println(max);
  }

  private static int getNextIndex(int cur) {
    return cur == N - 1 ? 0 : cur + 1;
  }

  private static void putOrIncrease(Map<Integer, Integer> map, int key) {
    if (map.containsKey(key)) {
      map.replace(key, map.get(key) + 1);
    } else {
      map.put(key, 1);
    }
  }

  private static void init(String s) {
    int[] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

    N = input[0];
    d = input[1];
    k = input[2];
    c = input[3];
  }

  private static int stoi(String s) {
    return Integer.parseInt(s);
  }
}
