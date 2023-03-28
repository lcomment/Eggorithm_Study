import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15683 {
    static int[][] map;
    static int N;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int start = Integer.parseInt(input[1]);
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(input[j]);
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);     //플로이드 와샬 알고리즘으로 최소 거리 구함
                }
            }
        }

        boolean[] visited = new boolean[N];
        visited[start] = true;
        dfs(visited, start, 0, 0);

        System.out.println(ans);
    }

    public static void dfs(boolean[] visited, int temp, int sum, int depth) {
        if(depth==N-1) {
            ans = Math.min(ans, sum);     //최단 거리 구하기
            return ;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(visited, i, sum+map[temp][i], depth+1);   //안지나간 정거장 지나가기
                visited[i] = false;
            }
        }
    }
}