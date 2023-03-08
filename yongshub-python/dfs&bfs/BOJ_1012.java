package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_1012 {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int[] arr = inputValues(br);
            graph = new int[arr[0]][arr[1]];
            int length = arr[2];
            for(int j = 0; j < length; j++) { // 배추 개수 만큼
                    arr = inputValues(br);
                    graph[arr[0]][arr[1]] = 1;
            }

            sb.append(solve()).append("\n");
        }
        System.out.println(sb);
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static int solve() {
        int cnt = 0;

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 1) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void bfs(int i, int j) {
        Queue<Integer> queue = new LinkedList<>(List.of(i, j));

        while(queue.size() > 0) {
            int x = queue.poll(), y = queue.poll();

            for(i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length || graph[nx][ny] == 0) {
                    continue;
                }

                graph[nx][ny] = 0;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }
}
