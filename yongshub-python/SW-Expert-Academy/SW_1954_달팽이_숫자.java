import java.io.BufferedReader;
import java.io.InputStreamReader;

class SW_1954 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int N;
    static int x, y;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N]; // 배열 초기화
            visited = new boolean[N][N];
            x = 0;
            y = 0;
            sb.append(String.format("#%d\n", test_case));
            dfs(0, 1);
        }
        System.out.print(sb);
    }

    public static void dfs(int direct, int cnt) {
        visited[x][y] = true; // 방문 처리
        arr[x][y] = cnt;

        if(cnt == N * N) { // 기저조건
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        int nx = x + dx[direct % 4];
        int ny = y + dy[direct % 4];

        if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) { // 배열을 벗어나는 좌표거나 방문한 노드라면
            direct++;
            nx = x + dx[direct % 4];
            ny = y + dy[direct % 4];
        }
        x = nx;
        y = ny;
        dfs(direct, cnt + 1);
    }
}