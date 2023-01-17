import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y, z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BOJ_7569 {
    static int[][][] arr;
    static int ripeTomato = 0;
    static int totalTomato = 0;
    static int N, M, Z;
    static boolean[][][] visited;
    static int[] dx = {-1 ,1 ,0 ,0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] initialize;
        Queue<Pair> queue = new LinkedList<>();

        initialize = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        M = initialize[0];
        N = initialize[1];
        Z = initialize[2];
        arr = new int[Z][N][M];
        visited = new boolean[Z][N][M];

        for(int z = 0; z < Z; z++) {
            for(int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for(int y = 0; y < M; y++) {
                    arr[z][x][y] = Integer.parseInt(st.nextToken());
                    if(arr[z][x][y] == 1) { // 익은 토마토라면
                        ripeTomato++;
                        totalTomato++;
                        visited[z][x][y] = true;
                        queue.add(new Pair(x, y, z));
                    } else if(arr[z][x][y] == 0) { // 익지 않은 토마토라면
                        totalTomato++;
                    }
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
        int nx, ny, nz;
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            totalTomato -= size;

            if(totalTomato == 0) {
                return answer;
            }
            for(int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for(int j = 0; j < 6; j++) {
                    nx = pair.x + dx[j];
                    ny = pair.y + dy[j];
                    nz = pair.z + dz[j];
                    if(isOutOfIndexWithVisited(nx, ny, nz)) {
                        continue;
                    }
                    visited[nz][nx][ny] = true;
                    queue.add(new Pair(nx, ny, nz));
                }
            }
            answer++;
        }
        return -1;
    }

    public static boolean isOutOfIndexWithVisited(int nx, int ny, int nz) {
        return nz < 0 || nz >= Z || nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nz][nx][ny] || arr[nz][nx][ny] == -1;
    }
}