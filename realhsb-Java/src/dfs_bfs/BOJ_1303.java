package dfs_bfs;

// 잘못 풀었다! 
// BOJ - 1303번 전투 

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_1303 {
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int count, white, blue;
	static char[][] field;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 가로 
		M = sc.nextInt();	// 세로 
		sc.nextLine();
		
		field = new char[M][N];
		visited = new boolean[M][N];
		white = 0;
		blue = 0;
		
		for(int i = 0; i < M; i++) {
			field[i] = sc.nextLine().toCharArray();
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					count = 0;
					BFS(i, j);
					if(field[i][j] == 'W') {	// 아군 
						white += Math.pow(count, 2);
					}else {	// 'B', 적군 
						blue += Math.pow(count, 2);
					}
				}
			}
		}
		System.out.println(white + " " + blue);
	}
	
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			visited[i][j] = true;
			count++;
			for(int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < M && y < N) {
					if(field[x][y] == field[i][j] && !visited[x][y]) {
						visited[x][y] = true;
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
}