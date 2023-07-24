import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;

        StringBuilder sb = new StringBuilder();
        for(int i=11; i<=100; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        while(count-- >0){
            int tmp = Integer.parseInt(br.readLine());
            sb.append(dp[tmp]).append("\n");
        }
        System.out.print(sb);
    }
}
