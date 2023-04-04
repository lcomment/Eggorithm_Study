package dfs_bfs;

// BOJ 7562 나이트의 이동 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_7562_나이트의이동 {
	static int[] dx = {1, 2, 1, 2, -1, -2, -1, -2};
	static int[] dy = {2, 1, -2, -1, 2, 1, -2, -1};
	static boolean[][] visited;
	static int T, I, answer;
	static Point start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine());	// 체스판 크기 
			visited = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			bfs();
		}
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			Point now = queue.poll();
			for(int i = 0; i < 8; i++) {
				int x1 = now.x + dx[i];
				int y1 = now.y + dy[i];
				
				if(now.x == end.x && now.y == end.y) {
					System.out.println(now.count);
					return;
				}else if(x1 < 0 || x1 >= I || y1 < 0 || y1 >= I || visited[x1][y1]) continue;
				
				visited[x1][y1] = true;
				queue.add(new Point(x1, y1, now.count + 1));
			}
		}
	}
	
	static class Point {
		int x, y, count;
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}


