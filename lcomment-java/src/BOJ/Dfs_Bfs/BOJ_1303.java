package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
	static boolean[][] visited;
	static int row, col;
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		boolean[][] whiteMap = new boolean[row][col];
		boolean[][] blueMap = new boolean[row][col];
		visited = new boolean[row][col];
		
		
		for(int i=0 ; i<row ; i++) {
			String s = br.readLine();
			
			for(int j=0 ; j<s.length() ; j++) {
				if(s.charAt(j) == 'W')
					whiteMap[i][j] = true;
				else
					blueMap[i][j] = true;
			}
		}
		
		int blue = 0, white=0;
		
		for(int i=0 ; i<row ; i++) {
			for(int j=0 ; j<col ; j++) {
				if(!visited[i][j]) {
					if(whiteMap[i][j]) {
						dfs(whiteMap, i, j);
						white += Math.pow(cnt, 2);
						cnt = 1;
					}
					else if(blueMap[i][j]) {
						dfs(blueMap, i, j);
						blue += Math.pow(cnt, 2);
						cnt = 1;
					}
				}
			} // for_i
		} // for_j
		System.out.println(white + " " + blue);
	}
	static void dfs(boolean[][] map, int x, int y) {
		
		visited[x][y] = true;
		
		if(x+1<row && map[x+1][y] && !visited[x+1][y]) {
			cnt++;
			dfs(map, x+1, y);
		}
		if(x>0 && map[x-1][y] && !visited[x-1][y]) {
			cnt++;
			dfs(map, x-1, y);
		}
		if(y+1<col && map[x][y+1] && !visited[x][y+1]) {
			cnt++;
			dfs(map, x, y+1);
		}
		if(y>0 && map[x][y-1] && !visited[x][y-1]) {
			cnt++;
			dfs(map, x, y-1);
		}
	}
}
