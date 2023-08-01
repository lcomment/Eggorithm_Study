import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10971 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] map;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<N; i++){
            visited[i] = true;
            backTracking(i, i,0, 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    private static void backTracking(int start,int now, int count,int sum) {
        if(count == N-1){
            if(map[now][start] == 0)    return;
            answer = Math.min(answer, sum+map[now][start]);
            return;
        }

        for(int i=0; i<N; i++){
            if(i==now || map[now][i] == 0)  continue;
            if(!visited[i]){
                visited[i] = true;
                backTracking(start, i,count+1, map[now][i] + sum);
                visited[i] = false;
            }
        }
    }
}
