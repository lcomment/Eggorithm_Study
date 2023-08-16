package greedy;

import java.util.Scanner;

// BOJ 11047 동전0

/*
 * 거슬러 줄 수 있는 동전의 가치가 오름차순으로 제공됨.
 * 배열을 역순으로 순회해야 가치가 큰 동전부터 계산할 수 있음.
 */

public class BOJ_11047_동전0 {
	static int N, K, ans;
	static int[] coins;
	
	public static void main(String[] args)   {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = scan.nextInt();
		}
		
		for (int i = N-1; i >= 0; i--) {
			if(K == 0) break;
			else if(K >= coins[i]) {
				ans += (K / coins[i]);
				K %= coins[i];
			}
		}
		System.out.println(ans);
	}
}
