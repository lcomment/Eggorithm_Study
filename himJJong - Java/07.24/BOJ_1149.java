import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = Integer.parseInt(br.readLine());

        int[][] data = new int[count][count];
        int[][] dp = new int[count][count];

        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = data[0][0];
        dp[0][1] = data[0][1];
        dp[0][2] = data[0][2];

        for(int i=1; i<=count-1; i++){
            for(int j=0; j<3; j++){
                if(j==0){
                    dp[i][j] += Math.min(dp[i-1][j+1], dp[i-1][j+2]) + data[i][j];
                }
                else if(j==1){
                    dp[i][j] += Math.min(dp[i-1][j+1], dp[i-1][j-1]) + data[i][j];
                }
                else {
                    dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j-2]) + data[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<2; i++){
            answer = Math.min(answer,Math.min(dp[count-1][i], dp[count-1][i+1]));
        }

        System.out.println(answer);
    }
}
