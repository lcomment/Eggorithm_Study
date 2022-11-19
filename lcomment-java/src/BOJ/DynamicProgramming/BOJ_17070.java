package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17070 {
	static int N;
	static int[][] map;
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0 ; i<N ; i++) 
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		dfs(0, 1, 0);
		
		System.out.println(count);
	}
	static void dfs(int r, int c, int d) {
		if(r==N-1 && c==N-1 && map[r][c]==0) {
			count++;
			return;
		}
		
		// 가로 방향 
		if(d==0) {
			if(r>=0 && c+1>=0 && r<N && c+1<N && map[r][c+1]==0) dfs(r, c+1, 0);
			if(r+1>=0 && c+1>=0 && r+1<N && c+1<N && map[r][c+1]==0 && map[r+1][c]==0 && map[r+1][c+1]==0) dfs(r+1, c+1, 2);
		}
		
		// 세로 방향 
		else if(d==1) {
			if(r+1>=0 && c>=0 && r+1<N && c<N && map[r+1][c]==0) dfs(r+1, c, 1);
			if(r+1>=0 && c+1>=0 && r+1<N && c+1<N && map[r][c+1]==0 && map[r+1][c]==0 && map[r+1][c+1]==0) dfs(r+1, c+1, 2);
		}
		
		// 대각선 방향 
		else if(d==2) {
			if(r>=0 && c+1>=0 && r<N && c+1<N && map[r][c+1]==0) dfs(r, c+1, 0);
			if(r+1>=0 && c>=0 && r+1<N && c<N && map[r+1][c]==0) dfs(r+1, c, 1);
			if(r+1>=0 && c+1>=0 && r+1<N && c+1<N && map[r][c+1]==0 && map[r+1][c]==0 && map[r+1][c+1]==0) dfs(r+1, c+1, 2);
		}
	}
}
