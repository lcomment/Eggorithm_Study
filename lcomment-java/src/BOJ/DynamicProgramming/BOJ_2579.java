package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] floor = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = floor[1];
		
		if(N > 1)
			dp[2] = floor[1] + floor[2];
		
		for(int i=3 ; i<=N ; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + floor[i-1]) + floor[i];
		}
		
		System.out.println(dp[N]);
	}
}