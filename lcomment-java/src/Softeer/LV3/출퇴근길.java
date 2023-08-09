package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class 출퇴근길 {

  static List<List<Integer>> adjList = new ArrayList<>();
  static int N, V, S, T;
  static Set<Integer> go = new HashSet<>();
  static Set<Integer> come = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    N = input[0];
    V = input[1];
    init();

    for (int i = 0; i < V; i++) {
      input = sToIntArray(br.readLine());
      adjList.get(input[0]).add(input[1]);
    }
    input = sToIntArray(br.readLine());
    S = input[0];
    T = input[1];
    boolean[] visited1 = new boolean[N + 1];
    boolean[] visited2 = new boolean[N + 1];

    bfs(S, T, visited1);
    bfs(T, S, visited2);

    int result = 0;
    for(int i=0 ; i<N ; i++) {
      if (i != S && i != T) {
        if(visited1[i] &&  visited2[i]) result++;
      }
    }
    System.out.println(result);
  }

  static void bfs(int node, int des, boolean[] visited) {
    Queue<Integer> q = new LinkedList<>();
    visited[node] = true;
    q.offer(node);

    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == des) {
        continue;
      }

      for (int next : adjList.get(cur)) {
        if (visited[next]) {
          continue;
        }
        visited[next] = true;
        q.offer(next);
      }
    }
  }

  static void init() {
    for (int i = 0; i <= N; i++) {
      adjList.add(new ArrayList<>());
    }
  }

  static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }
}
