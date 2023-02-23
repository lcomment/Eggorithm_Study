import java.util.*;
import java.io.*;

public class BOJ_11060 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numCount = Integer.parseInt(br.readLine());

        int[] data = new int[numCount+1];
        int[] dp = new int[1200];

        Arrays.fill(dp,Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numCount; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for(int i=1; i< numCount; i++){
            if(dp[i] >= Integer.MAX_VALUE) continue;
            for(int j=1; j<= data[i]; j++){
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        if(dp[numCount] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[numCount]);
    }
}
