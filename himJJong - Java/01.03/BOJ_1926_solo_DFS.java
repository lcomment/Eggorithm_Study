import java.io.*;
import java.util.*;

public class BOJ_1926_solo_DFS {
    static int n, m;                // n: 도화지 세로 크기, m: 도화지 가로 크기
    static boolean[][] paper;       // 가로 m, 세로 n 도화지
    static boolean[][] check;       // 방문 확인

    static int numberOfPicture = 0;     // 그림 개수
    static int maxArea = 0;             // 가장 넓은 그림의 넓이
    static int area = 0;                // 탐색한 그림의 넓이

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1};      // 상하좌우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new boolean[n][m];
        paper = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1)
                    paper[i][j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 해당 지점이 그림이고 아직 방문 안한 경우, 탐색 수행
                if (paper[i][j] && !check[i][j]) {
                    numberOfPicture++;
                    dfs(i, j);
                    // bfs(i, j);

                    maxArea = Math.max(maxArea, area);
                    area = 0;       // area 초기화
                }
            }
        }

        System.out.println(numberOfPicture);
        System.out.println(maxArea);
    }
    public static void dfs(int row, int col) {
        check[row][col] = true;
        area++;

        // 상하좌우 확인
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            // 1. 다음 지점이 도화지 범위 안이고
            if (0 <= nextRow && nextRow < n &&
                    0 <= nextCol && nextCol < m) {
                // 2. 그림이고 아직 방문 안한 경우
                if (paper[nextRow][nextCol] && !check[nextRow][nextCol])
                    dfs(nextRow, nextCol);
            }
        }
    }
}