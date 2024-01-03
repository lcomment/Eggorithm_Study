import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9466 {
    static int[] data;
    static int[] reverseData;
    static boolean[] visited;
    static boolean[] check;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            data = new int[N+1];
            count = 0;

            for(int j=1; j<=N; j++){
                data[j] = Integer.parseInt(st.nextToken());
            }

            reverseData = new int[N+1];
            check = new boolean[N+1];
            visited = new boolean[N+1];

            for(int j=1; j<=N; j++){
                if(!visited[j]){
                    dfs(j);
                }
            }
            System.out.println(N - count);
        }
    }

    private static void dfs(int val) {
        visited[val] = true;
        int next = data[val];

        if(!visited[next]){
            reverseData[next] = val;
            dfs(next);
        }
        else{
            if(!check[next]){
                cycle(val, next);
            }
        }
        check[val] = true;
    }

    private static void cycle(int val, int next) {
        count++;
        if(val == next){
            return;
        }
        cycle(reverseData[val],next );
    }
}