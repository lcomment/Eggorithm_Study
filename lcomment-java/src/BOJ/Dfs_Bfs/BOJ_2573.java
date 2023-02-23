package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2573 {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initNM(br.readLine());
        map = new int[N][M];

        for(int i=0 ; i<N ; i++) {
            map[i] = sToIntArray(br.readLine());
        }

        while(true) {
            int count = countIce();

            // 덩어리 없으면 걍 끝내~
            if(count == 0) {
                System.out.println(0);
                System.exit(0);
            }

            // 덩어리 2개 이상이면 나가~
            if(count >= 2) {
                break;
            }

            bfs();
            result++;
        }
        System.out.println(result);
    }

    private static int countIce() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for(int r=0; r<N ; r++) {
            for(int c=0 ; c<M ; c++) {
                if(map[r][c] == 0 || visited[r][c]) continue;

                dfs(r, c, visited);
                cnt++;
            }
        }
        return cnt;
    }

    private static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!in(nr, nc)) continue;
            if (map[nr][nc] == 0 || visited[nr][nc]) continue;

            dfs(nr, nc, visited);
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        // 얼음 넣기
        for(int r=0 ; r<N ; r++) {
            for(int c=0 ; c<M ; c++) {
                if(map[r][c] == 0) continue;
                q.offer(new Node(r, c));
                visited[r][c] = true;
            }
        }

        // 오랜만에 푸니까 졸라 헷갈린다 하
        while(!q.isEmpty()) {
            Node n = q.poll();


            int count = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.

            for (int i = 0; i < 4; i++) {
                int nr = n.r + dr[i];
                int nc = n.c + dc[i];

                if (!in(nr, nc)) continue;

                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    count++;
                }
            }

            map[n.r][n.c] = Math.max((map[n.r][n.c] - count), 0);
        }
    }

    private static boolean in(int r, int c) {
        return (0<=r && r<N) && (0<=c && c<M);
    }

    private static void initNM(String s) {
        int[] input = sToIntArray(s);

        N = input[0];
        M = input[1];
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
