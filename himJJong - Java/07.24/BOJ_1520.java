import java.io.*;
import java.util.*;

public class BOJ_1520 {
    static int N, M;
    static int[][] map;
    static int[][] cnt;
    static int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cnt[i][j] = -1;
            }
        }

        dfs(0, 0);
        System.out.println(cnt[0][0]);
    }
    public static int dfs(int x, int y) {
        if(x==N-1 && y==M-1) return 1;
        cnt[x][y] = 0;

        for(int i=0; i<4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX < 0 || moveX >=N || moveY < 0 || moveY >=M || map[moveX][moveY] >= map[x][y])  continue;
            if(cnt[moveX][moveY]!=-1) {
                cnt[x][y] += cnt[moveX][moveY];
            }
            else {
                cnt[x][y] += dfs(moveX, moveY);
            }
        }
        return cnt[x][y];
    }
}