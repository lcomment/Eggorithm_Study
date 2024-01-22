import java.io.*;
import java.util.*;

public class BOJ_1799 {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N, tmpResult;
    public static int[][] map;
    public static int[] dx = {-1, 1, 1, -1};
    public static int[] dy = {1, 1, -1, -1};

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static boolean isValid(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int amt = 1;
            while(true) {
                int X = x + amt * dx[d];
                int Y = y + amt * dy[d];
                if (X < 0 || Y < 0 || X >= N || Y >= N)
                    break;
                if (map[X][Y] == 2) return false;
                amt++;
            }
        }
        return true;
    }

    public static int calIncr(int ind) {
        //크기가 홀 수일 경우 -> 2증가
        if (N % 2 == 1) return 2;
        //크기가 짝수일 경우
        if (ind % N == N-1) return 1;
        else if (ind % N == N-2) return 3;
        else return 2;
    }

    public static void dfs(int ind, int cnt) {
        if (ind >= N*N) {
            tmpResult = Math.max(tmpResult, cnt);
            return;
        }
        int y = ind % N;
        int x = ind / N;
        int incr = calIncr(ind);

        //0. 둘 수 없는 곳일 경우
        if (map[x][y] == 0) {
            dfs(ind + incr, cnt);
            return;
        }

        //1. 둘 수 있는 곳일 경우
        if (isValid(x, y)) {
            map[x][y] = 2;
            dfs(ind+incr, cnt+1);
            map[x][y] = 1;
        }
        //2. 그냥 안두는 케이스
        dfs(ind+incr, cnt);
    }

    public static void solve() throws IOException {
        int result = 0;
        tmpResult = 0;
        //첫째칸부터 시작할 떄 DFS
        dfs(0, 0);
        result += tmpResult;
        tmpResult = 0;
        //두번째칸부터 시작할 때 DFS
        dfs(1, 0);
        result += tmpResult;
        bw.write(result + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}