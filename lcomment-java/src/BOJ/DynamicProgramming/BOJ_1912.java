package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        dp[0] = seq[0];

        for(int i= 1 ; i<N ; i++) {
            dp[i] = Math.max(seq[i], dp[i-1] + seq[i]);
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
