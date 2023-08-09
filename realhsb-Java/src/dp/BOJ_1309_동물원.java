package dp;

// BOJ 1309 동물

/*
 * i열에서 
 * 둘 다 비어있을 때 dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] 	-> dp[i-1][0] = dp[n-2]
 * 왼쪽에 사자	 	 dp[i][1] = dp[i-1][0] + dp[i-1][2]
 * 오른쪽에 사자 	 dp[i][2] = dp[i-1][0] + dp[i-1][1] 				(+
 * --------------------------------------------------------------
 * 				dp[n] = dp[n-1] * 2 + dp[i-1][0]
 * 				dp[n] = dp[n-1] * 2 + dp[n-2] 
 */

import java.util.Scanner;

public class BOJ_1309_동물원 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 3; 
		
		for(int n = 2; n <= N; n++) {
			dp[n] = ( dp[n-1] * 2 + dp[n-2] ) % 9901;
		}
		
		System.out.println(dp[N]);
	}
}
