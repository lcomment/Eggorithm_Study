package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_159993 {
    char[][] map;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int R, C;

    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];
        Node start = null, lever = null, exit = null;

        // map 초기화
        for(int r=0 ; r<R ; r++) {
            map[r] = maps[r].toCharArray();

            for(int c=0 ; c<C ; c++) {
                if(map[r][c] == 'S') {
                    start = new Node(r, c);
                } else if(map[r][c] == 'L') {
                    lever = new Node(r, c);
                } else if(map[r][c] == 'E') {
                    exit = new Node(r, c);
                }
            }
        }

        int cntFromStartToLever = bfs(start, lever);
        if(checkCannotArrive(cntFromStartToLever)) { return -1; }

        int cntFromLeverToExit = bfs(lever, exit);
        if(checkCannotArrive(cntFromLeverToExit)) { return -1; }

        return cntFromStartToLever + cntFromLeverToExit;
    }



    private int bfs(Node start, Node exit) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        boolean[][] visited = new boolean[R][C];
        visited[start.r][start.c] = true;

        int[][] dist = new int[R][C];
        for(int i=0 ; i<R ; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[start.r][start.c] = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            if(n.r == exit.r && n.c == exit.c) {
                return dist[exit.r][exit.c];
            }

            for(int d=0 ; d<4 ; d++) {
                int nr = dr[d] + n.r;
                int nc = dc[d] + n.c;

                if(!in(nr, nc)) continue;
                if(map[nr][nc] == 'X') continue;

                if(dist[n.r][n.c] + 1 < dist[nr][nc]) {
                    dist[nr][nc] = dist[n.r][n.c] + 1;
                    q.offer(new Node(nr, nc));
                }
            }
        }

        return -1;
    }

    private boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

    private boolean checkCannotArrive(int cnt) {
        return cnt == -1;
    }

    public static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}