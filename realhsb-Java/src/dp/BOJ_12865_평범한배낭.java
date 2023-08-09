package dp;

// BOJ 12865 평범한 배낭

/*	
 * 	예제 입력 1
 * 	dp[i][j]
 * 	i\j | 0 1 2 3 4 5  6  7 -> 가방의 무게, (최대값: K)
 * 	1	| 0 0 0 0 0 0  13 13
 * 	2	| 0 0 0 0 8 8  13 13
 * 	3	| 0 0 0 6 8 8  13 14
 * 	4	| 0 0 0 6 8 12 13 14 (답 : 14)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_12865_평범한배낭 {
	static int N, K;
	static int[] W, V;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		dp = new int[N + 1][K + 1];
		
		for(int i = 0; i <= N; i++) {	// 범위 조심!
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(W[i] > j) {	// 주어진 무게에 i번째 짐을 못 넣는 경우, 이전 값 가져오기 
					dp[i][j] = dp[i - 1][j];
				} else {	// 주어진 무게에 i번째 짐을 넣을 수 있는 경우
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
