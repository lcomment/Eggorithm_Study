package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	static class Node {
		int r, c, cnt;
		boolean status;
		
		Node(int r, int c, int cnt, boolean status){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.status = status;
		}
	}
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];	// 3차원 -> 0: 안부심 1: 부심 
		
		for(int i=0 ; i<N ; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, false));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.r == N-1 && n.c == M-1)
				return n.cnt;
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr<0 || nc<0 || nr>N-1 || nc>M-1) continue;
				
				// 벽인데 
				if(map[nr][nc] == 1) {
					// 부술 수 있으면 
					if(!n.status) {
						q.offer(new Node(nr, nc, n.cnt+1, true));
						visited[nr][nc][1] = true;
					}
					continue;
				}
				// 벽 아님 
				if(map[nr][nc] == 0) {
					// 벽 부신적이 없을 때 
					if(!visited[nr][nc][0] && !n.status) {
						visited[nr][nc][0] = true;
						q.offer(new Node(nr, nc, n.cnt+1, false));
					}
					// 벽 부신적이 있을 때 
					else if(!visited[nr][nc][1] && n.status) {
						visited[nr][nc][1] = true;
						q.offer(new Node(nr, nc, n.cnt+1, true));
					}
					
				}
			}
		}
		return -1;
	}
}
