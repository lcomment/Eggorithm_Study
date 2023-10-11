import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11725 {
    static List<Integer>[] list;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int value) {
        visited[value] = true;
        for(int k : list[value]){
            if(!visited[k]){
                parent[k] = value;
                dfs(k);
            }
        }
    }
}
