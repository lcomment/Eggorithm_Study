import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1987 {
    static int r, c;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static boolean[] alpha;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        r = scan.nextInt();
        c = scan.nextInt();
        scan.nextLine();

        //board를 입력받는다.
        board = new int[r][c];
        for(int i = 0; i < r; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        alpha = new boolean[26]; //알파벳을 이전에 방문했는지 여부 체크.
        backtracking(0, 0, 1);
        System.out.println(max);
    }

    public static void backtracking(int x, int y, int len) {
        alpha[board[x][y]] = true;
        max = Math.max(max, len);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c && !alpha[board[nx][ny]]) {
                backtracking(nx, ny, len + 1);
                alpha[board[nx][ny]] = false;
            }
        }
    }
}
