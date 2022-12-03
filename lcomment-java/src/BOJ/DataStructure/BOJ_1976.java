package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1976 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> adjList;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjList = new ArrayList<>();

        for(int i=0 ; i<=N ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=1 ; i<=N ; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int j=0 ; j<N ; j++){
                if(i == j+1 || input[j] == 0) continue;
                adjList.get(i).add(j+1);
                adjList.get(j+1).add(i);
            }
        }

        seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=1 ; i<M ; i++){
            if(!bfs(seq[i-1], seq[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static boolean bfs(int start, int destination){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == destination)
                return true;
            ArrayList<Integer> adj = adjList.get(cur);

            for(int next : adj){
                if(next == destination) return true;
                if(visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
        return false;
    }
}
