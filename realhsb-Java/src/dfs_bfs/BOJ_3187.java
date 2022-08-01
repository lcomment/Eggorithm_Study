package dfs_bfs;

// BOJ - 3187번 양치기 꿍 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3187 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static char[][] field;
	static int N, M;
	static int sheeps, wolves;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new char[N][M];
		int result[] = new int[2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			field[i] = line.toCharArray();
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(field[i][j]);
//			}
//			System.out.println();
//		}
		
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					sheeps = 0; wolves = 0;
					BFS(i, j);
					if(sheeps > wolves) {
						result[0] += sheeps;
					}else {
						result[1] += wolves;
					}
				}
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
	
	private static void BFS(int i, int j) {
		if(field[i][j] == 'k') sheeps++;
		else if(field[i][j] == 'v') wolves++;
		else if(field[i][j] == '#') return;
		visited[i][j] = true;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[i][j] = true;
			for(int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < N && y < M) {	// 좌표 유효성 검사 
					if(!visited[x][y] && field[x][y] != '#') {
						BFS(x, y);
					}
				}
			}
		}
	}
}
