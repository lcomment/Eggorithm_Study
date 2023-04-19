package dp;

import java.util.Scanner;

// BOJ 12888 완전 이진 트리 도로 네트워크 

public class BOJ_12888_완전이진트리도로네트워크 {
	static long[] dp;
	static long sum;
	static int H; // 0 ≤ H ≤ 60
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		H = scan.nextInt();
		dp = new long[61];
		
		dp[0] = 1;
		dp[1] = 1;
		sum = 1;
		
		for(int h = 2; h <= H; h++) {
			dp[h] = 1 + (2 * sum);
			sum += dp[h-1];
		}
		System.out.println(dp[H]);
	}
}
