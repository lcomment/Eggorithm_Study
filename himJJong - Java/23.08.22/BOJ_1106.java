import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1106 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int goal = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] dp = new int[goal+101];
        Arrays.fill(dp,987654321);
        dp[0] = 0;

        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j=b; j<goal+101; j++){
                dp[j] = Math.min(dp[j], a + dp[j-b]);
            }
        }
        for(int i=goal; i< goal+101; i++){
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);
    }
}
