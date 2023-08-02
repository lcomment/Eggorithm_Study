package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3055 {

  static int R, C;
  static char[][] map;
  static int[][] dist;
  static int[] dr = {0, -1, 0, 1};
  static int[] dc = {-1, 0, 1, 0};
  static Queue<Node> wq = new LinkedList<>();
  static Queue<Node> pq = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    R = input[0];
    C = input[1];
    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();

      for (int j = 0; j < C; j++) {
        if (map[i][j] == 'S') {
          pq.offer(new Node(i, j));
        } else if (map[i][j] == '*') {
          wq.offer(new Node(i, j));
        }
      }
    }

    int result = bfs();
    System.out.println(result == -1 ? "KAKTUS" : result);
  }

  static int bfs() {
    dist = new int[R][C];
    for (int i = 0; i < R; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }
    dist[pq.peek().r][pq.peek().c] = 0;

    while (!pq.isEmpty()) {
      int size = wq.size();
      for (int i = 0; i < size; i++) {
        Node water = wq.poll();

        for (int j = 0; j < 4; j++) {
          int wr = dr[j] + water.r;
          int wc = dc[j] + water.c;

          if (in(wr, wc) && enableCheck(wr, wc)) {
            map[wr][wc] = '*';
            wq.offer(new Node(wr, wc));
          }
        } // for_j
      } // for_i

      size = pq.size();
      for (int i = 0; i < size; i++) {
        Node porcupine = pq.poll();

        if (map[porcupine.r][porcupine.c] == 'D') {
          return dist[porcupine.r][porcupine.c];
        }

        for (int j = 0; j < 4; j++) {
          int pr = dr[j] + porcupine.r;
          int pc = dc[j] + porcupine.c;

          if (in(pr, pc)) {
            if (map[pr][pc] == 'D') {
              return Math.min(dist[porcupine.r][porcupine.c] + 1, dist[pr][pc]);
            }
            else if(enableCheck(pr, pc) && dist[porcupine.r][porcupine.c] + 1 < dist[pr][pc]) {
              dist[pr][pc] = dist[porcupine.r][porcupine.c] + 1;
              pq.offer(new Node(pr, pc));
            }
          }
        } // for_j
      } // for_i
    }
    return -1;
  }

  static boolean in(int r, int c) {
    return 0 <= r && r < R && 0 <= c && c < C;
  }

  static boolean enableCheck(int r, int c) {
    return map[r][c] == '.';
  }

  static class Node {

    int r, c, cnt;

    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
