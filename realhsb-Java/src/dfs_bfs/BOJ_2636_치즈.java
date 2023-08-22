package dfs_bfs;

// BOJ 2636 치즈

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] field;
	static boolean[][] isVisited;
	static Queue<Point> queue;
	static int M, N, sumCheez;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		field = new int[M][N];
		isVisited = new boolean[M][N];
		queue = new LinkedList<>();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (field[i][j] == 1) sumCheez++;	// 전체 치즈 개수 세기 
			}
		}
		
		int cheez = 0;
		int time = 0;
		while (sumCheez != 0) {	// 치즈가 다 녹을 때까지 반복 
			cheez = sumCheez;	// 남은 치즈 저장 
			time++;		
			BFS();
			isVisited = new boolean[M][N];	// (0, 0)부터 새로 BFS 작업을 하므로, 방문기록 초기화 
		}
		
		System.out.println(time);
		System.out.println(cheez);
		
	}
	
	private static void BFS() {
		queue.add(new Point(0, 0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			isVisited[p.x][p.y] = true;
			
			for (int i = 0; i < 4; i++) {
				int x_ = p.x + dx[i];
				int y_ = p.y + dy[i];
				
				// 범위를 벗어나거나 이미 방문했던 노드면 continue 
				if (x_ < 0 || y_ < 0 || x_ >= M || y_ >= N || isVisited[x_][y_]) continue;
				
				isVisited[x_][y_] = true;		// 분기 처리 조심하기! 
					
				if (field[x_][y_] == 1) {	// 치즈를 만났을 경우 
					field[x_][y_] = 0;		// 치즈 -> 공기 
					sumCheez--;				// 치즈가 녹았으므로 하나 감소 
					
				} else {	// 공기를 만났을 경우 (내부 구멍 제외)
					queue.add(new Point(x_, y_));	// 공기를 만나면 queue에 공기의 좌표 추가 
				}
			}
		}
	}
	
	private static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
