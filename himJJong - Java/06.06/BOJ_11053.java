import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] data = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(data[j] < data[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);

                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
