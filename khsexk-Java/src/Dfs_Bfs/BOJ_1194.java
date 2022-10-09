package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1194 {
	static class Node {
		int r, c, cnt, key;
	
		Node(int r, int c, int cnt, int key){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}
	
	static int R, C;
	static char[][] map;
	static boolean[][][] visited;
	static Node start;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] RC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = RC[0];
		C = RC[1];
		map = new char[R][C];
		visited = new boolean[R][C][64];
		boolean flag = false;
		
		for(int i=0 ; i<R ; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0 ; j<C && !flag ; j++) {
				char c= map[i][j];
				
				if(c == '0') {
					start = new Node(i, j, 0, 0);
					flag = true;
				}
			} // for_j
		} // for_i
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		visited[start.r][start.c][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(map[n.r][n.c] == '1') {
				return n.cnt;
			}
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr<0 || nc<0 || nr>R-1 || nc>C-1 || visited[nr][nc][n.key] || map[nr][nc] == '#') continue;
				
				// 키 주움 
				if('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
					int key = n.key | (1 << (map[nr][nc] - 'a')); 
					
					if(!visited[nr][nc][key]) {
						visited[nr][nc][key] = true;
						visited[nr][nc][n.key] = true;
						q.offer(new Node(nr, nc, n.cnt+1, key));
					}
				}
				else if('A' <= map[nr][nc] && map[nr][nc] <='Z') {
					int match = n.key & (1 << (map[nr][nc] - 'A'));
					
					if(match != 0) {
						visited[nr][nc][n.key] = true;
						q.offer(new Node(nr, nc, n.cnt+1, n.key));
					}
				}
				else {
					visited[nr][nc][n.key] = true;
					q.offer(new Node(nr, nc, n.cnt+1, n.key));
				}
			} // for_i
		} // while_q
		
		return -1;
	}
	
}

