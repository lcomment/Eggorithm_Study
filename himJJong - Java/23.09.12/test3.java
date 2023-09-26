import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test3 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+2][N+2];
        int[][] dp = new int[N+2][N+2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=2; j<N+2; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[N-1][2] = map[N-1][2];

        for(int i=N-1; i>=0; i--){
            for(int j=2; j<N+2; j++){
                if(dp[i][j] != 0)   continue;
                dp[i][j] = Math.max(Math.max(dp[i+2][j]+map[i][j]*2 , dp[i][j-2] +map[i][j]*2), Math.max(dp[i+1][j]+map[i][j],dp[i][j-1]+map[i][j]));
            }
        }
        System.out.println(dp[0][N+1]);
    }
}
