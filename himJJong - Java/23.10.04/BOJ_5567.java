import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5567 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] tmp = br.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);

            list[a].add(b);
            list[b].add(a);
        }
        visited[1] = true;
        dfs(1,0);

        for(int i=2; i<N+1; i++){
            if(visited[i])  answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int i, int count) {
        if(count == 2){
            return;
        }
        for(int val : list[i]){
            visited[val] = true;
            dfs(val,count+1);
        }
    }
}
