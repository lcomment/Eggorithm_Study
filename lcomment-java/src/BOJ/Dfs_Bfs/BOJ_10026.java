package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
	static int N, case1=0, case2=0;
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	static class Node {
		int r, c;
		char color;
		
		Node(int r, int c, char color){
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i=0 ; i<N ; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(!visited1[i][j])
					bfs1(new Node(i, j, map[i][j]));
				if(!visited2[i][j])
					bfs2(new Node(i, j, map[i][j]));
			}
		}
		System.out.println(case1 + " " + case2);
	}
	
	static void bfs1(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		visited1[node.r][node.c] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > N-1 || nc > N-1) continue;
				
				if(n.color == map[nr][nc] && !visited1[nr][nc]) {
					visited1[nr][nc] = true;
					q.offer(new Node(nr, nc, n.color));
				}
			}
		}
		case1++;
	}
	static void bfs2(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		visited2[node.r][node.c] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > N-1 || nc > N-1) continue;
				
				if(!visited2[nr][nc]) {
					if(n.color == 'B' && n.color == map[nr][nc]) {
						visited2[nr][nc] = true;
						q.offer(new Node(nr, nc, n.color));
					}
					else if(n.color != 'B' && (map[nr][nc] == 'G' || map[nr][nc] == 'R')) {
						visited2[nr][nc] = true;
						q.offer(new Node(nr, nc, n.color));
					}
				}
			}
		}
		case2++;
	}
}
