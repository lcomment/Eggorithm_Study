import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15900 {
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
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

        dfs(1,0);
        if(answer %2 == 0){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }

    private static void dfs(int val, int count) {
        visited[val] = true;
        int index = 0;
        for(int k : list[val]){
            if(!visited[k]){
                dfs(k, count+1);
                index++;
            }
        }
        if(index == 0){
            answer += count;
        }
    }
}
