package dp;

// BOJ 2839 설탕배달 

/*
 * if 5의 배수, 
 * if 3의 배수, 
 */

import java.util.Scanner;

public class BOJ_2839_설탕배달 {
	static Long N;
	static Long[] dp;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextLong();
		dp = new Long[(int) (N+1)];
		
		if(N >= 5) dp[5] = 1L;
		if(N >= 3) dp[3] = 1L;
		
		for(int i = 6; i <= N; i++) {
			if(i % 5 == 0) {
				dp[i] = dp[i-5] + 1;
			} else if(i % 3 == 0) {
				dp[i] = dp[i-3] + 1;
			} else if(dp[i-5] != 0 && dp[i-3] != 0) {
				dp[i] = Math.min(dp[i-5], dp[i-3]) + 1;
			}
		}
		
		System.out.println(dp[N] != 0 ? dp[N] : -1);
	}
}
