import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] M = br.readLine().toCharArray();

        int[][] dp = new int[S.length+1][M.length+1];
        int max = Integer.MIN_VALUE;

        for(int i=1; i<S.length; i++){
            for(int j=1; j<M.length; j++){
                if(S[i-1] == M[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}