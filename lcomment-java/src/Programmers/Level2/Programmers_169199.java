package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_169199 {
    char[][] map;
    int[][] dist;
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    int R, C;

    public int solution(String[] board) {
        Node start = null, end = null;

        R = board.length;
        C = board[0].length();
        map = new char[R][C];
        dist = new int[R][C];

        for(int i=0 ; i<board.length ; i++) {
            map[i] = board[i].toCharArray();
            Arrays.fill(dist[i], Integer.MAX_VALUE);

            for(int j=0 ; j<board[0].length() ; j++) {
                if(map[i][j] == 'R') start = new Node(i, j, 0);
                else if(map[i][j] == 'G') end = new Node(i, j, Integer.MAX_VALUE);
            }
        }

        return bfs(start, end);
    }

    private int bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        dist[start.r][start.c] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.r == end.r && n.c == end.c) {
                return n.cnt;
            }

            for(int i=0 ; i<4 ; i++) {
                int nr = n.r, nc = n.c;
                // 위 아래로 움직임
                if(i==0 || i==1) {
                    while(in(nr, nc + dc[i]) && map[nr][nc + dc[i]] != 'D') {
                        nc += dc[i];
                    }
                }
                // 양 옆으로 움직임
                else {
                    while(in(nr + dr[i], nc) && map[nr + dr[i]][nc] != 'D') {
                        nr += dr[i];
                    }
                }

                if(dist[nr][nc] <= n.cnt + 1)
                    continue;

                dist[nr][nc] = n.cnt + 1;
                q.offer(new Node(nr, nc, dist[nr][nc]));
            } // for_i
        } // while
        return -1;
    }

    private boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }
}

class Node {
    int r, c, cnt;

    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}