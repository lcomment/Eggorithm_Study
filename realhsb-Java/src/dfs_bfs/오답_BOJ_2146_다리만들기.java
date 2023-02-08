package dfs_bfs;

// BOJ 2146 다리만들기 (89% 틀렸습니다)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.stream.*;
import java.util.LinkedList;

public class 오답_BOJ_2146_다리만들기 {
	static int N, line;
	static int min = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] field, dist;
	static Queue<Point> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N][N];
		field = new int[N][N];
		dist = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			field[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		line = 2; 
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && field[i][j] == 1) {
					BFS_count(i, j);
					line++;
				}
			}
		}
		
		for(int i = 2; i < line; i++) {
			BFS_dist(i);
		}
		
		System.out.println(min);
		
	}
	
	// 섬을 구분해주는 BFS (섬의 번호는 2부터 시작 2, 3, 4 ...)
	static void BFS_count(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(i, j));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			field[x][y] = line;
			visited[x][y] = true;
			
			for(int k = 0; k < 4; k++) {
				int x1 = x + dx[k];
				int y1 = y + dy[k];
				
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= N) continue;
				
				else if(!visited[x1][y1] && field[x1][y1] == 1) {
					visited[x1][y1] = true;
					queue.offer(new Point(x1, y1));
				}
			}
			
			
		}
	}
	
	static void BFS_dist(int line_) {
		Queue<Point> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(field[i][j] == line_) {
					queue.offer(new Point(i, j));
					dist[i][j] = 0;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int x = now.x;
			int y = now.y;
			
			for(int i = 0; i < 4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];

				
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= N) continue;
				
				else if(field[x1][y1] == 0) {	// 바다를 만날 경우 
					if(dist[x][y] + 1 < min) {
						queue.offer(new Point(x1, y1));
						dist[x1][y1] = dist[x][y] + 1;
					}
					
				}
				
				// 여기 조건이 문제인가? 
				else if(line_ != field[x1][y1] && field[x1][y1] > 1) {
					min = Math.min(dist[x][y], min);
					break;
				}
			}
		}
	}
	
	
	static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}



//6
//1 1 0 0 0 2
//1 0 0 0 0 0
//0 0 0 0 0 0
//0 0 0 0 0 0
//3 0 0 0 0 0
//0 0 0 0 0 0

//10
//1 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 0
//0 0 0 0 0 0 0 0 0 1

//5
//1 0 0 0 1
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//1 1 0 0 1

