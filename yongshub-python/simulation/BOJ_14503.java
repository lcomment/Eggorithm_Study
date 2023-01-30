import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다.
//d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
public class BOJ_14503 {
    static int[][] graph;
    static boolean[][] visited;
    static int startX, startY, direction;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] directions = {3, 0, 1, 2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] inputs = inputValues(br);

        graph = new int[inputs[0]][inputs[1]];
        visited = new boolean[inputs[0]][inputs[1]];
        inputs = inputValues(br);
        startX = inputs[0];
        startY = inputs[1];
        direction = inputs[2];

        for(int i = 0; i < graph.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int bfs() {
        int answer = 1;
        visited[startX][startY] = true;
        Deque<Integer> queue = new LinkedList<>(List.of(startX, startY));

        while(!queue.isEmpty()) {
            int x = queue.pollFirst();
            int y = queue.pollFirst();

            boolean isNotAdd = true;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length || visited[nx][ny] || graph[nx][ny] > 0) {
                    direction = directions[direction];
                    continue;
                }
                direction = directions[direction];
                visited[nx][ny] = true;
                answer++;
                queue.add(nx);
                queue.add(ny);
                isNotAdd = false;
                break;
            }

            if(isNotAdd) {
                int move = directions[direction];
                x = x + dx[move];
                y = y + dy[move];

                if(x < 0 || x >= graph.length || y < 0 || y >= graph[0].length || graph[x][y] > 0) {
                    break;
                } else {
                    queue.add(x);
                    queue.add(y);
                }
            }
        }
        return answer;
    }
}
