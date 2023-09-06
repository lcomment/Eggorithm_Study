import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = data[1];

        int max = Integer.MIN_VALUE;

        for(int i=2; i<=N; i++){
            dp[i] = data[i];
            for(int j=1; j<i; j++){
                if(data[i] > data[j]){
                    dp[i] = Math.max(dp[i], dp[j] + data[i]);
                }
            }
        }
        for(int i=1; i<=N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
