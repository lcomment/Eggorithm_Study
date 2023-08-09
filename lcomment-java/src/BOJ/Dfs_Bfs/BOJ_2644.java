package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2644 {

  static int N, M, start, end;
  static List<List<Integer>> adjList = new ArrayList<>();
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = stoi(br.readLine());
    init();
    dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    int[] input = sToIntArray(br.readLine());
    start = input[0];
    end = input[1];
    M = stoi(br.readLine());

    for (int i = 0; i < M; i++) {
      input = sToIntArray(br.readLine());
      adjList.get(input[0]).add(input[1]);
      adjList.get(input[1]).add(input[0]);
    }

    bfs(start);

    System.out.println(dist[end] == Integer.MAX_VALUE ? -1 : dist[end]);
  }

  static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);

    dist[start] = 0;

    while (!q.isEmpty()) {
      int cur = q.poll();

      for (int next : adjList.get(cur)) {
        if (dist[cur] + 1 < dist[next]) {
          q.offer(next);
          dist[next] = dist[cur] + 1;
        }
      }
    }
  }

  static void init() {
    for (int i = 0; i < N + 1; i++) {
      adjList.add(new ArrayList<>());
    }
  }

  static int stoi(String s) {
    return Integer.parseInt(s);
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

}
