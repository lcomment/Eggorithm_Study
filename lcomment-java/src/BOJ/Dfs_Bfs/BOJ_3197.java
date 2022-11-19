package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197 {
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
    static int R, C;
  	static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
    static Node[] swan = new Node[2];
	static Queue<Node> waterQ = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
	
		map = new char[R][C];
		visited = new boolean[R][C];
		
		int swanIdx = 0;
		for(int r = 0 ; r < R ; ++r) {
			char[] line = br.readLine().toCharArray();
			for(int c = 0 ; c < C ; ++c) {
				map[r][c] = line[c];
				if(map[r][c] == 'L') {
					swan[swanIdx++] = new Node(r, c);
				}
				if(map[r][c] != 'X') {
					waterQ.offer(new Node(r, c));
				}
			}
		}
		
        Queue<Node> q = new LinkedList<>();
		q.offer(swan[0]);
		visited[swan[0].r][swan[0].c] = true;
		
		int cnt = 0;
        
		Loop:
		while(true) {
			Queue<Node> meltingIce = new LinkedList<>();
			while(!q.isEmpty()) {
				Node n = q.poll();
				
				if(n.r == swan[1].r && n.c == swan[1].c) {
					break Loop;
				}
				
				for(int i = 0 ; i < 4 ; i++) {
					int nr = n.r + dr[i];
					int nc = n.c + dc[i];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					
					if(map[nr][nc] == 'X') {
						meltingIce.offer(new Node(nr, nc));
						continue;
					}
					q.offer(new Node(nr, nc));
				}
			}
			
			q = meltingIce;
			int size = waterQ.size();
			
			for(int i = 0 ; i < size ; i++) {
				Node water = waterQ.poll();
				
				for(int j = 0 ; j < 4 ; j++) {
					int nr = water.r + dr[j];
					int nc = water.c + dc[j];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0) continue;
					
					if(map[nr][nc] == 'X') {
						map[nr][nc] = '.';
						waterQ.offer(new Node(nr, nc));
					}
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
}