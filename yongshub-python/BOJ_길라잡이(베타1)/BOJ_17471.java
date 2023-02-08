package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_17471 {
    static int[] peoples;
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        int idx = 1;
        graph = new int[N + 1][];
        visited = new boolean[N + 1];

        //비트 마스킹
        int fullStats = (1 << N) - 1;
        for (int i : inputValues(br)) { // 인구 입력 받기
            peoples[idx++] = i;
        }

        for(int i = 1; i < N + 1; i++) { // 그래프 동적 할당
            graph[i] = inputValues(br);
        }

        solve(fullStats);
    }

    public static int[] inputValues(BufferedReader br) throws IOException {

        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void solve(int fullStats) {
        int totalSum = Arrays.stream(peoples).sum();

        for(int i = 1; i < fullStats; i++) {
            int a = bfs(i), b = bfs(fullStats ^ i);
            if(a + b != totalSum) continue;
            answer = Math.min(answer, Math.abs(a - b));
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static int bfs(int num) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int total = 0;

        boolean isCheck = false;
        for(int i = 0; i < N; i++) {
            if((num &(1 << i)) == 0) visited[i + 1] = true; // 방문할 수 없는 노드는 방문 처리
            if(!isCheck && ((num &(1 << i)) >= 1)) {
                queue.add(i + 1);
                visited[i + 1] = true;
                isCheck = true;
            }
        }

        while(!queue.isEmpty()) {
            int number = queue.poll();
            total += peoples[number];
            for(int node : graph[number]) {
                if(visited[node]) continue; // 이미 방문했다면
                queue.add(node);
                visited[node] = true;
            }
        }
        return total;
    }
}
