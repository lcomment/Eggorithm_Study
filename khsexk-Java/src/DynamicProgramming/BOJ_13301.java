package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13301 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		
		dp[1] = 1;
		if(N>=2) {
			dp[2] = 1;
		}
		
		for(int i=3 ; i<N+1 ; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		long result = 2 * (dp[N] + dp[N-1]) + 2*dp[N];
		
		System.out.println(result);
	}

}
