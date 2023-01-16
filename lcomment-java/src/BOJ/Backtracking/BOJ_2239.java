package BOJ.Backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_2239 {
    static int[][] map = new int[9][9];
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int r=0 ; r<9 ; r++) {
            map[r] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dfs(0);

        for(int r=0 ; r<9 ; r++) {
            for(int c=0 ; c<9 ; c++) {
                bw.write(String.valueOf(map[r][c]));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int d) {
        if(d == 81) {
            flag = true;
            return;
        }

        int r = d / 9;
        int c = d % 9;

        if(map[r][c] != 0) dfs(d + 1);

        else {
            for(int i=1 ; i<10 ; i++) {
                if(!checked(r, c, i)) continue;

                map[r][c] = i;
                dfs(d + 1);

                if(flag) return;
                map[r][c] = 0;
            }
        }
    }

    private static boolean checked(int r, int c, int n) {
        // 가로 또는 세로에 해당 수가 있을 때 false
        for(int i=0 ; i<9 ; i++) {
            if(map[i][c] == n || map[r][i] == n)
                return false;
        }

        // 작은 칸(3X3) 계산
        int squareR = r / 3 * 3;
        int squareC = c - c % 3;

        for(int i=squareR ; i<squareR+3 ; i++) {
            for(int j=squareC ; j<squareC+3 ; j++) {
                if(map[i][j] == n) return false;
            }
        }
        return true;
    }
}
