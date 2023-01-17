package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2606 {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        M = sToI(br.readLine());
        adjList = new ArrayList[N+1];
        initAdjList();

        // 간선 리스트 초기화
        for(int i=0 ; i<M ; i++) {
            int[] input = sToIntArray(br.readLine());

            adjList[input[0]].add(input[1]);
            adjList[input[1]].add(input[0]);
        }

        System.out.println(bfs());
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void initAdjList() {
        for(int i=1 ; i<=N ; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int cnt = 0;

        while(!q.isEmpty()) {
            int n = q.poll();

            ArrayList<Integer> adj = adjList[n];
            for(int next : adj) {
                if(visited[next]) continue;

                q.offer(next);
                visited[next] = true;
                cnt++;
            }
        }
        return cnt;
    }
}
