import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2688 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[65][10];

        Arrays.fill(dp[1],1);

        for(int i=2; i<=64; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        while(N-- >0){
            int data = Integer.parseInt(br.readLine());

            long answer = 0;
            for(int i=0; i<10; i++){
                answer += dp[data][i];
            }

            System.out.println(answer);
        }
    }
}
