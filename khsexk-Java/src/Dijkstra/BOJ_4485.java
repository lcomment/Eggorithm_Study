package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_4485 {
	static class Node implements Comparable<Node> {
		int r, c, cost;

		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			
			for(int i=0 ; i<N ; i++)
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			dijkstra(N);
		}

	}
	public static void dijkstra(int size) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, map[0][0]));
		
		dist = new int[size][size];
		for(int i=0 ; i<size ; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = map[0][0];
		
		visited = new boolean[size][size];
		visited[0][0] = true;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=size || nc>=size) continue;
				if(visited[nr][nc] || dist[nr][nc] <= dist[n.r][n.c] + map[nr][nc]) continue;
				
				dist[nr][nc] = dist[n.r][n.c] + map[nr][nc];
				pq.offer(new Node(nr, nc, dist[nr][nc]));
				visited[nr][nc] = true;
			}
		}
		System.out.println("Problem " + (cnt++) + ": " + dist[size-1][size-1]);
	}

}
