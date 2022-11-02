package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_2206_벽부수고이동하기 {
	static int N, M;	// 1 <= N, M <= 1,000
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static char[][] field;			// 입력 받은 값을 저장할 이중 배열 
	static boolean[][][] visited;	
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		field = new char[N][M];		
		visited = new boolean[N][M][2];
//									[0] : 벽을 뚫지 않고 방문 여부
//									[1] : 벽을 뚫고 난 후 방문 여부 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			field[i] = st.nextToken().toCharArray();
		}
		System.out.println(BFS());
		
	}
	
	static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 1, false));
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			int count = now.count;
			count++;

			// 1 1
			// 0
			// 1<= N, M <= 1,000 범위 확인, 예외 케이스 
			// 아래 조건에서 탐색 끝남 			
			if(now.x == N-1 && now.y == M-1) {
				min = Math.min(now.count, min);
				break; 
			}

			
			for(int i = 0; i < 4; i++) {
				int x1 = now.x + dx[i];
				int y1 = now.y + dy[i];
				
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) 	continue; // 범위 확인 
				
				if(field[x1][y1] == '0') {			// 길 
					
					if(!now.broken && !visited[x1][y1][0]) {		// 여태 벽 부순 적 X, 안 부순 상태로 방문한 적 X
						queue.add(new Point(x1, y1, count, false));
						visited[x1][y1][0] = true;
					}else if(now.broken && !visited[x1][y1][1]) {	// 여테 벽 부순 적 O, 부순 상태로 방문한 적 X  
						queue.add(new Point(x1, y1, count, true));
						visited[x1][y1][1] = true;
					}
					
				}else if(field[x1][y1] == '1') {	// 벽 
					
					if(!now.broken)	{								// 여태 부순 적 X 
						queue.add(new Point(x1, y1, count, true));
						visited[x1][y1][1] = true;
					}
				}
			}
		}
		if(min == Integer.MAX_VALUE) min = -1;
		return min;
	}
	
	static class Point {
		int x, y, count;
		boolean broken;
		public Point(int x, int y, int count, boolean broken) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.broken = broken;
		}
	}
}