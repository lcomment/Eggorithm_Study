package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15989 {
	static int[] testCase; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		testCase = new int[N];
		
		for(int i=0 ; i<N ; i++)
			testCase[i] = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[10001][3];
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		
		for(int i=4 ; i<10001 ; i++) {
			dp[i][0] = dp[i-1][0];
			dp[i][1] = dp[i-2][0] + dp[i-2][1];
			dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
		}
		
		for(int test : testCase)
			System.out.println(dp[test][0] + dp[test][1] + dp[test][2]);

	}

}
