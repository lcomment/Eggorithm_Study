package dfs_bfs;

// BOJ 18809 Gaaaaaaaaaarden
// 백트래킹 + BFS 

/* 
 * 
 * <문제 조건>
 *  행 N(2 ≤ N ≤ 50), 열 M(2 ≤ M ≤ 50)
 *  초록색 배양액의 개수 G(1 ≤ G ≤ 5), 빨간색 배양액의 개수 R(1 ≤ R ≤ 5)
 *  0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅
 *  배양액을 뿌릴 수 있는 땅의 수는 R+G개 이상이고 10개 이하
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BOJ_18809_Gaaaaaaaaaarden {
	
	static class Pos {
		int x, y, time;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
			this.time = 0;
		}
	}
	
	static class Pair {
		int time, type;
		
		Pair() {};
		Pair(int time, int type) {
			this.time = time;
			this.type = type;
		}
	}
	
	static int N, M, G, R;	// 행 N, 열 M, 초록 G, 빨강 R 
	static int max = Integer.MIN_VALUE;
	static int[][] garden;
	static boolean[] visited;	// 배양액을 뿌렸는지 여부 배열 
	static int[] reds, greens;
	static ArrayList<Pos> yes_list;	// 배양액을 뿌릴 수 있는 땅 목록 
	static final int LAKE = 0, NO = 1, YES = 2;
	static final int RED = 3, GREEN = 4, FLOWER = 5;
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 변수 입력 받기 
		N =	Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		garden = new int[N][M];
		yes_list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
				if(garden[i][j] == YES) {
					yes_list.add(new Pos(i, j));
				}
			}
		}
		
		visited = new boolean[10];
		reds = new int[R];
		greens = new int[G];
		
		green_perm(0,0);
		System.out.println(max);
		
	}
	
	static void green_perm(int depth, int r) {
		if(r == G) {
			red_perm(0, 0);
			return;
		}
		
		for(int i = depth; i < yes_list.size(); i++) {	// 참고해서 쓴 건데 내가 공부한 방식이랑 달라서 다시 확인해야 함 ... 
			if(!visited[i]) {
				visited[i] = true;
				greens[r] = i; 
				green_perm(i+1, r+1);
				visited[i] = false;
			}
		}
	}
	
	static void red_perm(int depth, int r) {
		if(r == R) {
			bfs();	// 배양액 퍼뜨리기 
			return;
		}
		
		for(int i = depth; i < yes_list.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				reds[r] = i; 
				red_perm(i+1, r+1);
				visited[i] = false;
			}
		}
	}
	
	
	
	static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		Pair[][] field = new Pair[N][M];
		int sum = 0;
		
		// field 초기화 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				field[i][j] = new Pair(0,0);
			}
		}
		
		// 초록 배양액 뿌리기 
		for(int i = 0; i < G; i++) {
			Pos p = yes_list.get(greens[i]);
			field[p.x][p.y] = new Pair(0, GREEN);
			queue.offer(new Pos(p.x, p.y));
		}
		
		// 빨강 배양액 뿌리기 
		for(int i = 0; i < R; i++) {
			Pos p = yes_list.get(reds[i]);
			field[p.x][p.y] = new Pair(0, RED);
			queue.offer(new Pos(p.x, p.y));		
		}
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			int x = p.x;
			int y = p.y;
			int currTime = field[x][y].time;
			int currType = field[x][y].type;
			
			if(currType == FLOWER) continue;
			
			for(int i = 0; i < 4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];
				
				// 유효한 범위가 아니거나, 호수라면 continue;
				if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M || garden[x1][y1] == LAKE) continue;
				if(field[x1][y1].type == 0) {
					field[x1][y1] = new Pair(currTime + 1, currType);
					queue.offer(new Pos(x1, y1));
				} else if(field[x1][y1].type == RED) {
					if(currType == GREEN && currTime + 1 == field[x1][y1].time) {
						sum++;
						field[x1][y1].type = FLOWER;
					}
				} else if(field[x1][y1].type == GREEN) {
					if(currType == RED && currTime + 1 == field[x1][y1].time) {
						sum++;
						field[x1][y1].type = FLOWER;
					}
				}
			}
		}
		max = Math.max(sum, max);
	}
}
