package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {
	static int r, c;
	static Node start, end;
	static int[][] map;
	static int[][] mirror;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		mirror = new int[r][c];
		
		boolean flag = true;
		for(int i=0 ; i<r ; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0 ; j<c ; j++) {
				if(input[j] == '.') map[i][j] = 0;
				else if(input[j] == '*') map[i][j] = -1;
				else {
					if(flag) {
						start = new Node(i, j, -1, 0);
						flag = false;
					}
					else
						end = new Node(i, j, -1, 0);
				}
			} // for_j
		} // for_i
		
		dijkstra();
		System.out.println(mirror[end.r][end.c]);
	}
	
	// 상1 하2 좌3 우4
	static void dijkstra() {
		for(int[] m : mirror)
			Arrays.fill(m, Integer.MAX_VALUE);
		mirror[start.r][start.c] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(start);
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dx[i];
				int nc = n.c + dy[i];
				
				if(nr < 0 || nc < 0 || nr > r-1 || nc > c-1 || map[nr][nc] == -1) continue;
				
				if(n.d == -1 || n.d == i) {
					if(mirror[nr][nc] >= n.cnt) {
						mirror[nr][nc] = n.cnt;
						pq.offer(new Node(nr, nc, i, n.cnt));
					}
				}
				
				else {
					if(mirror[nr][nc] >= n.cnt + 1) {
						mirror[nr][nc] = n.cnt + 1;
						pq.add(new Node(nr, nc, i, n.cnt + 1));
					}
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int d;
		int cnt;
		
		Node(int r, int c, int d, int cnt){
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}
}