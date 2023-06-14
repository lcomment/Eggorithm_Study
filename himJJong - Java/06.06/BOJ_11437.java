import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11437 {
    static class Node{
        int vertex;
        Node link;
        Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
    static int N,M;
    static boolean[] visited;
    static int[] depth;
    static int[] parent;
    static Node[] graph;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[N+1];
        graph = new Node[N+1];

        for(int i=0; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start] = new Node(end, graph[start]);
            graph[end] = new Node(start,graph[end]);
        }

        dfs(1,0);

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
    }

    private static int lca(int a, int b) {
        while(depth[a] != depth[b]){
            if(depth[a] > depth[b]) a = parent[a];
            else b = parent[b];
        }

        while(a!=b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void dfs(int v, int d) {
        visited[v] = true;
        depth[v] = d;

        for(Node temp = graph[v]; temp != null; temp = temp.link){
            if(!visited[temp.vertex]){
                parent[temp.vertex] = v;
                dfs(temp.vertex, d+1);
            }
        }
    }


}