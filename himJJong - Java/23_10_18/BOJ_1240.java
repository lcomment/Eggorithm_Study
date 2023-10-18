import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1240 {
    static int N;
    static int M;
    static int[][] score;
    static boolean[] visited;
    static List<Integer>[] list;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        score = new int[N+1][N+1];

        for(int i=1; i<N; i++){
            String[] tmp = br.readLine().split(" ");

            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);

            list[a].add(b);
            list[b].add(a);
            score[a][b] = c;
            score[b][a] = c;
        }

        while(M-- >0){
            answer = 0;
            visited = new boolean[N+1];
            String[] tmp = br.readLine().split(" ");
            dfs(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), 0);
            System.out.println(answer);
        }
    }

    private static void dfs(int from, int to, int count) {
        if(from == to){
            answer = count;
            return;
        }
        visited[from] = true;
        for(int k : list[from]){
            if(!visited[k]){
                dfs(k,to, count + score[from][k]);
            }
        }
    }
}