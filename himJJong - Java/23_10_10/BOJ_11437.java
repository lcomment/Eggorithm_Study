import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11437{
    static int vertexNum;
    static List<Integer>[] tree;
    static int m;
    static int[] depth;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        vertexNum = Integer.parseInt(br.readLine());
        tree = new ArrayList[vertexNum+1];
        depth = new int[vertexNum+1];
        parent = new int[vertexNum+1];

        for(int i=1; i<=vertexNum; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<vertexNum-1; i++){
            String[] tmp = br.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            tree[a].add(b);
            tree[b].add(a);
        }

        m = Integer.parseInt(br.readLine());
        dfs(1,1);   //점점들 depth 구하기

        for(int i=0; i<m; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            int same = solve(a,depth[a],b,depth[b]);
            System.out.println(same);
        }
    }

    private static int solve(int a, int a_depth, int b, int b_depth) {
        // 둘의 Depth 같아질때까지 위로 올리기
        if(a_depth > b_depth){
            while(a_depth != b_depth){
                a_depth--;
                a = parent[a];
            }
        }
        else if(a_depth < b_depth){
            while(b_depth != a_depth){
                b_depth--;
                b = parent[b];
            }
        }
        while(a!=b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    private static void dfs(int from, int cnt) {
        depth[from] = cnt++;
        for(int next : tree[from]){
            if(depth[next] == 0){
                dfs(next,cnt);
                parent[next] = from;
            }
        }
    }
}
