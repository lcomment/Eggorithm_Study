package Softeer.LV3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GINI야_도와줘 {

  static int R, C;
  static char[][] map;
  static int[][] dist;
  static Queue<Node> q = new LinkedList<>();
  static Queue<Node> rainQ = new LinkedList<>();
  static Node wash, home;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    R = input[0];
    C = input[1];
    map = new char[R][C];
    dist = new int[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
      Arrays.fill(dist[i], Integer.MAX_VALUE);

      for (int j = 0; j < C; j++) {
        if (map[i][j] == '*') {
          rainQ.offer(new Node(i, j));
        } else if (map[i][j] == 'W') {
          wash = new Node(i, j);
        } else if (map[i][j] == 'H') {
          home = new Node(i, j);
        }
      }
    }

    bfs();
    System.out.println(dist[home.r][home.c] == Integer.MAX_VALUE ? "FAIL" : dist[home.r][home.c]);
  }

  static void bfs() {
    q.offer(wash);
    dist[wash.r][wash.c] = 0;

    LOOP:
    while (!q.isEmpty()) {
      int size = rainQ.size();
      for (int i = 0; i < size; i++) {
        Node rain = rainQ.poll();

        for (int j = 0; j < 4; j++) {
          int rainR = dr[j] + rain.r;
          int rainC = dc[j] + rain.c;

          if (canSpread(rainR, rainC)) {
            map[rainR][rainC] = '*';
            rainQ.offer(new Node(rainR, rainC));
          }
        }
      } // rain_for

      size = q.size();

      for (int i = 0; i < size; i++) {
        Node n = q.poll();

        if (n.r == home.r && n.c == home.c) {
          break LOOP;
        }

        for (int j = 0; j < 4; j++) {
          int nr = n.r + dr[j];
          int nc = n.c + dc[j];

          if (!canMove(nr, nc)) {
            continue;
          }
          if (dist[n.r][n.c] + 1 < dist[nr][nc]) {
            q.offer(new Node(nr, nc));
            dist[nr][nc] = dist[n.r][n.c] + 1;
          }
        }
      } // for_q
    }
  }

  static boolean canMove(int r, int c) {
    return in(r, c) && (map[r][c] == '.' || map[r][c] == 'H');
  }

  static boolean canSpread(int r, int c) {
    return in(r, c) && (map[r][c] == '.');
  }

  static boolean in(int r, int c) {
    return 0 <= r && r < R && 0 <= c && c < C;
  }

  static class Node {

    int r, c;

    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}