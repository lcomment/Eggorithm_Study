package dp;

// BOJ 2157 여행 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2157_여행 {
	
	static int N, M, K, ans;
	static int[][] graph, dp;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];	// N -> N 도시로 갈 때 
		dp = new int[N+1][M+1];	
		
		initGraph();
		dp();
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		

		for (int i = 1; i <= M; i++) {
			ans = Math.max(ans, dp[N][i]);
		}
		System.out.println(ans);
	}
	
	private static void initGraph() throws IOException {
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = Math.max(graph[a][b], c);
		}
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		dp[1][1] = 0;	// 시작 도시는 0으로 초기화 
		
	}
	
	private static void dp() {
		for (int i = 1; i <= N; i++) {	// N
			for (int j = 1; j <= M; j++) {	// M 
				for (int k = 1; k < i; k++) {
					if (graph[i-k][i] == 0 || dp[i - k][j - 1] == -1) continue;
					dp[i][j] = Math.max(dp[i][j], dp[i - k][j - 1] + graph[i - k][i]);
				}
			}
		}
	}
}
