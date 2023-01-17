import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_7576 {
    static int[][] arr;
    static int ripeTomato = 0;
    static int totalTomato = 0;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1 ,1 ,0 ,0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Pair> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) { // 익은 토마토라면
                    ripeTomato++;
                    totalTomato++;
                    visited[i][j] = true;
                    queue.add(new Pair(i, j));
                } else if(arr[i][j] == 0) { // 익지 않은 토마토라면
                    totalTomato++;
                }
            }
        }

        if(isAllRipe(ripeTomato)) { // 저장될 때 부터 모두 익은 상태라면
            System.out.println(0);
        } else {
            System.out.println(bfs(queue));
        }
    }

    public static boolean isAllRipe(int ripeTomato) {
        return totalTomato == ripeTomato;
    }

    public static int bfs(Queue<Pair> queue) {
        int nx, ny;
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            totalTomato -= size;

            if(totalTomato == 0) {
                return answer;
            }
            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for(int j = 0; j < 4; j++) {
                    nx = pair.x + dx[j];
                    ny = pair.y + dy[j];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M  || visited[nx][ny] || arr[nx][ny] == -1) {
                        continue;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
            answer++;
        }
        return -1;
    }
}