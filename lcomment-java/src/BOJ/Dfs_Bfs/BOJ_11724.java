package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11724 {
    static int V, E, count = 0;
    static Set[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();

        for(int i=1; i<=V ; i++) {
            if(visited[i]) continue;

            bfs(i);
            count++;
        }

        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int n = q.poll();

            Set<Integer> adj = adjList[n];
            for(int next : adj) {
                if(visited[next]) continue;

                visited[next] = true;
                q.offer(next);
            }
        }
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = sToIntArray(br.readLine());

        V = input[0];
        E = input[1];

        adjList = new HashSet[V + 1];
        visited = new boolean[V + 1];

        for(int i=1 ; i<=V ; i++) adjList[i] = new HashSet<>();

        for(int i=0; i<E ; i++) {
            input = sToIntArray(br.readLine());

            adjList[input[0]].add(input[1]);
            adjList[input[1]].add(input[0]);
        }
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
