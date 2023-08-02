package dfs_bfs;

// BOJ 1520 내리막길
// 1 <= M(지도의 세로 크기) <= 500
// 1 <= N(지도의 가로 크기) <= 500
// 각 지점의 높이는 10000이하의 자연수

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_1520_내리막길 {
	static int[][] field, visited;
	static int M, N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		init();
		bfs();
		System.out.println(visited[M-1][N-1]);
	}
	
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		
		field = new int[M][N];
		visited = new int[M][N];
		
		// String array to Integer array
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			field[i] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
		}
	}
	
	
	static void bfs() {
		// Priority Queue를 사용해서 내림차순 정렬
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, field[0][0]));
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for(int i = 0; i < 4; i ++) {
				int x1 = now.x + dx[i];
				int y1 = now.y + dy[i];
				
				if (x1 < 0 || y1 < 0 || x1 >= M || y1 >= N) continue;
				if (field[x1][y1] < now.p) {
					if (visited[x1][y1] == 0)
						queue.add(new Point(x1, y1, field[x1][y1]));
					visited[x1][y1] += visited[now.x][now.y];
				}
				
				
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int x, y, p;
		public Point(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
		
		@Override
		public int compareTo(Point o) {
			return o.p - this.p;
		}
	}
}
