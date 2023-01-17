package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576 {
	static class Node {
		int r, c, day;
		
		Node(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}
	static int R, C, result = 0;
	static int[][] map;	// 층, 행, 열
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		initStaticVariable(br.readLine());
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0 ; i<R ; i++) {
			map[i] = sToIntArr(br.readLine());
		}
		
		
		while(true) {
			for(int r=0 ; r<R ; r++) {
				for(int c=0 ; c<C ; c++) {
					// 익은 토마토인 경우
					if(map[r][c] == 1 && !visited[r][c]) {
						q.offer(new Node(r, c, 0));
						visited[r][c] = true;	
					}
				}
			}
		
			if(q.isEmpty()) {
				break;
			}
			
			bfs();
		}
		System.out.println(checkChangeFinish() ? result : -1);
	}
	
	private static int[] sToIntArr(String s) {
		return Arrays.stream(s.split(" "))
				.mapToInt(Integer::parseInt).toArray();
	}
	
	private static void initStaticVariable(String s) {
		int[] input = sToIntArr(s);
		
		C = input[0];
		R = input[1];
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Node n = q.poll();

			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(!in(nr, nc) || !changePossible(nr, nc) || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				map[nr][nc] = 1;
				q.offer(new Node(nr, nc, n.day + 1));
				result = Math.max(result, n.day+1);
			}
			
		}
		
		
	}
	
	private static boolean in(int r, int c) {
		return (0<=r && r<R) && (0<=c && c<C);
	}
	
	private static boolean changePossible(int r, int c) {
		return map[r][c] == 0;
	}
	
	private static boolean checkChangeFinish() {
		for(int r=0 ; r<R ; r++) {
			for(int c=0 ; c<C ; c++) {
				if(map[r][c] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}

}
