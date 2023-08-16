package dp;

// BOJ 2502 떡 먹는 호랑이 

/*
 * 할머니가 넘어온 날 D (3 ≤ D ≤ 30)와 그 날 호랑이에게 준 떡의 개수 K (10 ≤ K ≤ 100,000)
 * 
 * x
 * y
 * x + y
 * x + 2y
 * 2x + 3y
 * 3x + 5y
 * 5x + 8y
 * ...
 * 
 * x의 계수에 대한 1차원 배열 dp1, y의 계수에 대한 1차원 배열 dp2
 */

import java.util.Scanner;

public class BOJ_2502_떡먹는호랑이 {
	static int D, K, A, B;
	static int[] dp1, dp2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		D = scan.nextInt();
		K = scan.nextInt();
		
		dp1 = new int[D + 1];
		dp2 = new int[D + 1];
		
		// x의 계수에 대한 dp 
		dp1[1] = 1;
		dp1[2] = 0;
		
		// y의 계수에 대한 dp 
		dp2[1] = 0;
		dp2[2] = 1;
		
		for (int i = 3; i <= D; i++) {
			dp1[i] = dp2[i-1];
			dp2[i] = dp1[i-1] + dp2[i-1];
		}
		
		// 2중 for문 시간 초과 -> O(n^2)
//		for (int j = 1; j <= K; j++) {
//			for (int i = 1; i < j; i++) {
//				if (i * dp1[D] + j * dp2[D] == K) {
//					A = i;
//					B = j;
//					break;
//				}
//			}
//		}
		
		/*
		 * K = ax + by
		 * K - ax = by
		 * (K - ax) / b = y
		 */
		
		// O(n) 이게 맞나 
		for (int a = 1; a < K; a++) {
			if ((K - dp1[D] * a) % dp2[D] == 0) {
				A = a;
				B = (K - dp1[D] * a) / dp2[D];
				break;
			}
		}
		
		System.out.println(A + "\n" + B);
	}
}
