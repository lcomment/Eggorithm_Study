package dp;

//BOJ 1660 캡틴 이다솜

/*
 * 1 <= N <= 300,000
 * 
 * 한 모서리의 개수가 n인 사면체의 총 구슬 개수
 * n * (n+1) * (n+2) / 6
 * 
 * 생각해보니까 시그마 n 점화식 가지고 누적합으로 사면체 구슬 개수 구해도 되는 걸,,,
 * 
 */

import java.util.Scanner;

public class BOJ_1660_캡틴이다솜 {
	
	static int N, num;
	static int[] balls, dp;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		balls = new int[150];
		dp = new int[N + 1];
		
		num = 0;
		int n = 0;
		while (N > num) {
			num = n * (n+1) * (n+2) / 6;	// 한 모서리의 개수가 n인 사면체의 총 구슬 개수
			balls[n] = num;	// 1, 4, 10, ...
			n++;
		}
		
		for (int i = 0; i <= N; i++) {
			dp[i] = N;
			for(int b : balls) {
				if (b == i) {
					dp[i] = 1;	// 사면체를 만들 수 있는 구슬 개수이므로, 1로 초기화 
					break;
				} else if (b > i) break;
				
				dp[i] = Math.min(dp[i - b] + 1, dp[i]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
