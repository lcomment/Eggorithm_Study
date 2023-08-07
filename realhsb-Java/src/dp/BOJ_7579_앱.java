package dp;

// BOJ 7579 앱

/* DP
 * mem\cost
 *  	
	0	0	30	30	30	30	30	30	30	30	30	30	30	30	30	
	10	10	40	40	40	40	40	40	40	40	40	40	40	40	40	
	10	10	40	40	40	60	60	60	60	60	60	60	60	60	60	
	10	10	40	40	40	60	60	75	75	75	95	95	95	95	95	
	10	10	40	40	50	60	80	80	80	100	100	115	115	115	135	
 * 			
 * 
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
	static int[] A, C;
	static int[][] dp;
	static int N, M, totalCost;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 앱의 개수 
		M = Integer.parseInt(st.nextToken()); // 필요한 메모리 
		
		A = new int[N+1];
		C = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
			totalCost += C[i];
		}
		

		dp = new int[N+1][totalCost+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= totalCost; j++) {
				// BOJ 12865 평범한 배낭이랑 조건을 헷갈렸다...
				
				if(j >= C[i]) {	// 주어진 cost(j)보다 소요 cost(C[i])가 작을 경우, 최댓값 비교!
								// 1. 이전 행에서 C[i]비용 안쓰고 확보한 메모리 값 + 이번 행에서 C[i]비용으로 확보한 메모리 
								// 2. 이전 행에서 같은 비용 써서 확보한 메모리
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - C[i]] + A[i]);
				} else {	// 주어진 무게에 i번째 짐을 넣을 수 있는 경우
					dp[i][j] = dp[i - 1][j];
				}

				if(dp[i][j] >= M) {
					answer = Math.min(answer, j);
				}
			}
			
		}
		
		System.out.println(answer);
	}
}
