package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6087 {
	static int mirrors = Integer.MAX_VALUE;
	static boolean[][] visited;
	static Laser[] lPoint;
	static int row, col;
	static int dot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[row][col];
		lPoint = new Laser[2];
		visited = new boolean[row][col];
		
		int idx = 0;
		for(int i=0 ; i<row ; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0 ; j<col ; j++) {
				map[i][j] = input[j];
				//System.out.print(map[i][j]);
				if(map[i][j] == 'C')
					lPoint[idx++] = new Laser(i, j);
				if(map[i][j] == '*') {
					visited[i][j] = true;
					
				}
				else {
					dot++;
				}
			}
			//System.out.println();
		}
		
		visited[lPoint[0].x][lPoint[0].y] = true;
		
		dfs(map, visited, lPoint[0].x, lPoint[0].y, 0, 0, 0);
		
		System.out.println(mirrors);
	}
	// 1(상),2(하), 3(좌), 4(우)
	static void dfs(char[][] map, boolean[][] visited, int x, int y, int cnt, int dir, int v) {
		//System.out.println(cnt + " x:" + x + " y:" + y + " dir:" + dir);
		if(x == lPoint[1].x && y == lPoint[1].y) {
			 mirrors = Math.min(cnt, mirrors);
			 return;
		}
		if(v == dot) {
			mirrors = Math.min(mirrors, v);
			//System.out.println("dot: " + v);
			return;
		}
		
		// 처음 상태(방향이 없을 때) 
		if(dir == 0) {
			if(x>0 && !visited[x-1][y]) {  // 위쪽 이동 
				visited[x-1][y] = true;
				dfs(map, visited, x-1, y, cnt, 1, v+1);
				visited[x-1][y] = false;
			}
			if(x<row-1 && !visited[x+1][y]) { // 아래쪽 이동 
				visited[x+1][y] = true;
				dfs(map, visited, x+1, y, cnt, 2, v+1);
				visited[x+1][y] = false;
			}
			if(y>0 && !visited[x][y-1]) { // 왼쪽 이동
				visited[x][y-1] = true;
				dfs(map, visited, x, y-1, cnt, 3, v);
				visited[x][y-1] = false;
			}
			if(y<col-1 && !visited[x][y+1]) {  // 아래쪽 이동 
				visited[x][y+1] = true;
				dfs(map, visited, x, y+1, cnt, 4, v+1);
				visited[x][y+1] = false;
			}
		}
		else if(dir==1) {
			if(x>0 && !visited[x-1][y]) {  // 위쪽 이동 
				visited[x-1][y] = true;
				dfs(map, visited, x-1, y, cnt, 1, v+1);
				visited[x-1][y] = false;
			}
			if(y>0 && !visited[x][y-1]) { // 왼쪽 이동
				visited[x][y-1] = true;
				dfs(map, visited, x, y-1, cnt+1, 3, v+1);
				visited[x][y-1] = false;
			}
			if(y<col-1 && !visited[x][y+1]) {  // 오른쪽 이동 
				visited[x][y+1] = true;
				dfs(map, visited, x, y+1, cnt+1, 4, v+1);
				visited[x][y+1] = false;
			}
		}
		else if(dir==2) {
			if(x<row-1  && !visited[x+1][y]) { // 아래쪽 이동 
				visited[x+1][y] = true;
				dfs(map, visited, x+1, y, cnt, 2, v+1);
				visited[x+1][y] = false;
			}
			if(y>0 && !visited[x][y-1]) { // 왼쪽 이동
				visited[x][y-1] = true;
				dfs(map, visited, x, y-1, cnt+1, 3, v+1);
				visited[x][y-1] = false;
			}
			if(y<col-1 && !visited[x][y+1]) {  // 오른쪽 이동 
				visited[x][y+1] = true;
				dfs(map, visited, x, y+1, cnt+1, 4, v+1);
				visited[x][y+1] = false;
			}
		}
		else if(dir==3) {
			if(x>0 && !visited[x-1][y]) {  // 위쪽 이동 
				visited[x-1][y] = true;
				dfs(map, visited, x-1, y, cnt+1, 1, v+1);
				visited[x-1][y] = false;
			}
			if(x<row-1 && !visited[x+1][y]) { // 아래쪽 이동 
				visited[x+1][y] = true;
				dfs(map, visited, x+1, y, cnt+1, 2, v+1);
				visited[x+1][y] = false;
			}
			if(y>0 && !visited[x][y-1]) { // 왼쪽 이동
				visited[x][y-1] = true;
				dfs(map, visited, x, y-1, cnt, 3, v+1);
				visited[x][y-1] = false;
			}
		}
		else if(dir==4) {
			if(x>0 && !visited[x-1][y]) {  // 위쪽 이동 
				visited[x-1][y] = true;
				dfs(map, visited, x-1, y, cnt+1, 1, v+1);
				visited[x-1][y] = false;
			}
			if(x<row-1 && !visited[x+1][y]) { // 아래쪽 이동 
				visited[x+1][y] = true;
				dfs(map, visited, x+1, y, cnt+1, 2, v+1);
				visited[x+1][y] = false;
			}
			if(y<col-1 && !visited[x][y+1]) {  // 오른쪽 이동 
				visited[x][y+1] = true;
				dfs(map, visited, x, y+1, cnt, 4, v+1);
				visited[x][y+1] = false;
			}
		}
	}
}
class Laser {
	int x;
	int y;
	Laser(int x, int y) {
		this.x = x;
		this.y = y;
	}
}