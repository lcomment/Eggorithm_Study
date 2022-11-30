package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1987 {
    static int R, C, result = 0;
    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        R = input[0];
        C = input[1];
        map = new char[R][C];

        for(int i=0 ; i<R ; i++){
            map[i] = br.readLine().toCharArray();
        }

        backtracking(0, 0, 0);
        System.out.println(result);
    }

    static void backtracking(int r, int c, int cnt){
        if(visited[map[r][c] - 'A']){
            result = Math.max(result, cnt);
            return;
        }

        visited[map[r][c] - 'A'] = true;
        for(int i=0 ; i<4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(in(nr, nc)) {
                backtracking(nr, nc, cnt + 1);
            }
        }
        visited[map[r][c]- 'A'] = false;
    }

    static boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }
}
