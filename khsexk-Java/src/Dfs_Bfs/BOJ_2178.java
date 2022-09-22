package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {
	static int[][] map;
	static boolean[][] visited;
	static int R, C;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static class Node {
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = input[0];
		C = input[1];
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0 ; i<R ; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		bfs();
		System.out.println(map[R-1][C-1]);
	}
	
	static void bfs() {
		int cnt = 0;
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.r == R-1 && n.c == C-1)
				break;
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr <0 || nc <0 || nr > R-1 || nc > C-1 || map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				q.offer(new Node(nr, nc));
				visited[nr][nc] = true;
				map[nr][nc] = map[n.r][n.c] + 1; 
			}
		}
	}
}
