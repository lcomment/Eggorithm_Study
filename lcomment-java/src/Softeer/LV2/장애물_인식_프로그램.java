package Softeer.LV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 장애물_인식_프로그램 {

  static char[][] map;
  static boolean[][] visited;
  static int N;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, -1, 0, 1};
  static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if(!visited[r][c] && map[r][c] == '1')
          bfs(r, c);
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for(Integer num : list) {
      System.out.println(num);
    }
  }

  static void bfs(int r, int c) {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(r, c));
    visited[r][c] = true;
    int count = 0;

    while(!q.isEmpty()) {
      Node n = q.poll();
      count++;
      for(int i=0 ; i<4 ; i++) {
        int nr = n.r + dr[i];
        int nc = n.c + dc[i];

        if(in(nr, nc) && map[nr][nc] == '1' && !visited[nr][nc]) {
          visited[nr][nc] = true;
          q.offer(new Node(nr, nc));
        }
      }
    }
    list.add(count);
  }

  static boolean in(int r, int c) {
    return 0<=r && r<N && 0<=c && c<N;
  }

  static class Node {

    int r, c;

    Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
