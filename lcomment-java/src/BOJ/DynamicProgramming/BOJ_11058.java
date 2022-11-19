package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11058 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			dp[i] = dp[i-1] + 1;
			
			for(int j=1 ; j<i-2 ; j++) 
				dp[i] = Math.max(dp[i], (j+1)*dp[i-(j+2)]);
		} // for
		
		System.out.println(dp[N]);
	}
}
