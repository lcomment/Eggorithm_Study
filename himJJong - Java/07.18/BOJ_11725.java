import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static StringTokenizer st;
    static ArrayList<Integer> list[];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int value) {
        visited[value] = true;
        for(int k: list[value]){
            if(!visited[k]){
                parent[k] = value;
                dfs(k);
            }
        }
    }
}
