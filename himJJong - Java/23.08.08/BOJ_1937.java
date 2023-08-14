import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1937 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveY < 0 || moveX >= N || moveY >= N) {
                continue;
            }
            if (map[x][y] < map[moveX][moveY]) {
                dp[x][y] = Math.max(dp[x][y], dfs(moveX, moveY) + 1);
            }
        }
        return dp[x][y];
    }
}