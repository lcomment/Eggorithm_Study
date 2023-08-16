package dfs_bfs;

// BOJ 1937 욕심쟁이 판다 

/*
 * DFS만 하면 시간초과로 혼난다...!
 * DFS로 모든 구역에서 한 번씩 출발하되,
 * 이미 방문한 구역이 있으면 dp로 그 구역의 최대값을 가져와서
 * 추가적인 연산을 막는다(?)
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1937_욕심쟁이판다 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, answer;
	static int[][] field;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		field = new int[N][N];
		dp = new int[N][N];
		answer = 1;
		
		for (int i = 0; i < N; i++) {
			field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answer = Math.max(answer, DFS(i, j));
			}
		}
		
		System.out.println(answer);
	}
	
	private static int DFS (int x, int y) {
		if(dp[x][y] != 0) return dp[x][y];	// 해당 위치에 값이 이미 있을 때, 바로 값 리턴 
		
		// 판다가 한 구역의 대나무를 먹기 때문에 
		// 기본값을 1로 초기화한다.
		dp[x][y] = 1;	
		
		for(int i = 0; i < 4; i++) {
			int x1 = x + dx[i];
			int y1 = y + dy[i];
			
			if(x1 < 0 || y1 < 0 || x1 >= N || y1 >= N) continue;	// 범위 초과 or 미만일 경우 continue
			
			if(field[x][y] < field[x1][y1]) {
				dp[x][y] = Math.max(dp[x][y], DFS(x1, y1) + 1);
			}
		}
		return dp[x][y];
	}
}

/* DFS만 사용했을 때, 33% 시간 초과 
 * 	private static int DFS (int x, int y, int a) {
		int ans = a;
		for(int i = 0; i < 4; i++) {
			int x1 = x + dx[i];
			int y1 = y + dy[i];
			
			if(x1 < 0 || y1 < 0 || x1 >= n || y1 >= n) continue;	// 범위 초과 or 미만일 경우 continue
			
			if(field[x][y] < field[x1][y1]) {
				ans = Math.max(ans, DFS(x1, y1,(a+1)));
			}
		}
		return ans;
	}
 */

