import java.io.*;
import java.util.*;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = data[0];
        int max = data[0];

        for(int i=1; i <N; i++){
            dp[i] = Math.max(dp[i-1]+data[i],data[i]);
            max = Math.max(dp[i],max);
        }

        System.out.println(max);
    }
}
