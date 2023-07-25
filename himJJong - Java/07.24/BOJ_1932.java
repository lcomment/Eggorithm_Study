import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] data = new int[N][N];
        int[][] dp = new int[N][N];

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<tmp.length;j++){
                data[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        if(N == 1){
            System.out.println(data[0][0]);
            System.exit(0);
        }
        else if(N==2){
            System.out.println(data[0][0] + Math.max(data[1][0], data[1][1]));
            System.exit(0);
        }
        dp[0][0] = data[0][0];
        dp[1][0] = dp[0][0] + data[1][0];
        dp[1][1] = dp[0][0] + data[1][1];

        for(int i=2; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(j==0){
                    dp[i][j] += data[i][j] + dp[i-1][j];
                }
                else if(j==i){
                    dp[i][j] += data[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] += data[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            max = Math.max(max, dp[N-1][i]);
        }
        System.out.println(max);
    }
}
