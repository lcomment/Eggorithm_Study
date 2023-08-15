import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int backpack = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] weight = new int[backpack+1];
        int[] value = new int[backpack+1];
        int[][] dp = new int[backpack+1][limit+1];

        for(int i=1; i<=backpack; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=backpack; i++){
            for(int j=1; j<=limit; j++){        // 무게
                dp[i][j] = dp[i-1][j];          //이전 것 들고오다가
                if(j - weight[i] >= 0){         // j 무게가 현재 i 무게보다 크거나 같다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[backpack][limit]);
    }
}
