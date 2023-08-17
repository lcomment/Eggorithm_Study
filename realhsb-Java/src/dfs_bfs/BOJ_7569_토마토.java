package dfs_bfs;

// BOJ 7569 토마토

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569_토마토 {
	static int M, N, H, non;
	static int[][][] field;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int ans = -10;
	static Queue<Tomato> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		field = new int[M][N][H];
		queue = new LinkedList<Tomato>();	// 익은 토마토를 담는 큐 
		non = 0;							// 안 익은 토마토 개수 
		
		// init
		for (int z = 0; z < H; z++) {		// 높이부터 반복문 돌기 
			for (int y = 0; y < N; y++) {	// z -> y -> x 순서 조심하기 
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					int c = Integer.parseInt(st.nextToken());
					field[x][y][z] = c;
					if (c == 1) {			// 익은 토마토면 queue에 담기 
						queue.offer(new Tomato(x, y, z, 0));
					} else if (c == 0) non++;	// 안 익은 토마토는 개수 세기 
				}
			}
		}	
		
		if (non == 0) {						// 안 익은 토마토가 0개라면, 바로 0 출력 후 종료.
			System.out.println(0);
			return;
		}
		
		bfs();
		
		System.out.println(ans != -10 ? ans : -1);
	}
	
	private static void bfs() {
		while (!queue.isEmpty()) {
			Tomato t = queue.poll();
			for (int i = 0; i < 6; i++) {
				int x_ = t.x + dx[i];
				int y_ = t.y + dy[i];
				int z_ = t.z + dz[i];
				
				// 범위 오류, 토마토가 없을 경우 -> continue 
				if (x_ < 0 || y_ < 0 || z_ < 0 || x_ >= M || y_ >= N || z_ >= H || field[x_][y_][z_] == -1) continue;
				else if (field[x_][y_][z_] == 0) {
					field[x_][y_][z_] = 1;
					non--;
					if(non == 0) {	// 안 익은 토마토가 더이상 없을 경우, 토마토가 전부 익는 날짜 전달 후 종료 
						ans = (t.count + 1);
						return;
					}
					queue.add(new Tomato(x_, y_, z_, t.count + 1));		// 다음 토마토로 넘어갈 때, count 1 증가 
				}
			}
		}
	}
	
	private static class Tomato {
		int x, y, z, count;
		public Tomato(int x, int y, int z, int count) {	// count : 토마토가 익는 일수 
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
		}
	}
}
