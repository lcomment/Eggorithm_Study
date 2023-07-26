package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1520 {
  static int[][] map, count;
  static int R, C;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = sToIntArray(br.readLine());
    R = input[0];
    C = input[1];
    map = new int[R][C];
    count = new int[R][C];

    for(int i=0 ; i<R ; i++) {
      map[i] = sToIntArray(br.readLine());
    }

    bfs();
    System.out.println(count[R-1][C-1]);
  }

  private static void bfs() {
    // Queue 쓰면 씹힘
    PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n2.h - n1.h);
    q.offer(new Node(0, 0, map[0][0]));
    count[0][0] = 1;

    while(!q.isEmpty()) {
      Node n = q.poll();

      for(int i=0 ; i<4 ; i++) {
        int nr = n.r + dr[i];
        int nc = n.c + dc[i];

        if(!in(nr, nc)) continue;
        if(map[n.r][n.c] <= map[nr][nc]) continue;

        if(count[nr][nc] == 0) {
          q.offer(new Node(nr, nc, map[nr][nc]));
        }
        count[nr][nc] += count[n.r][n.c];
      }
    }
  }

  private static boolean in(int r, int c) {
    return 0<=r && r<R && 0<=c && c<C;
  }

  private static int[] sToIntArray(String s) {
    return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  static class Node {
    int r, c, h;

    Node(int r, int c, int h) {
      this.r = r;
      this.c = c;
      this.h = h;
    }
  }
}
