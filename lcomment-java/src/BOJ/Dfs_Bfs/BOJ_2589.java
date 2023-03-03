package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589 {
    static class Node {
        int r, c, cnt;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
            this.cnt = 0;
        }
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    static int R, C, result = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init(br.readLine());
        map = new char[R][C];

        for(int i=0 ; i<R ; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int r=0 ; r<R ; r++) {
            for(int c=0 ; c<C ; c++) {
                if(map[r][c] == 'L') {
                    visited = new boolean[R][C];
                    result = Math.max(result, bfs(r, c));
                }
            } // for_c
        } // for_r

        System.out.println(result);
    }


    private static void init(String s) {
        int[] input = sToIntArray(s);

        R = input[0];
        C = input[1];
    }
    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        visited[r][c] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            Node n = q.poll();

            for(int i=0 ; i<4 ; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if(!in(nr, nc)) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 'L') continue;

                q.offer(new Node(nr, nc, n.cnt + 1));
                cnt = Math.max(n.cnt + 1, cnt);
                visited[nr][nc] = true;

            }
        }
        return cnt;
    }

    private static boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }
}
