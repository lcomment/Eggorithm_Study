import java.io.*;
import java.util.*;

public class codeTree_dp {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] dp = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=N-1; i>=0; i--){
            for(int j=1; j<=N; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])+map[i][j-1];
            }
        }

        System.out.println(dp[0][N]);
    }
}