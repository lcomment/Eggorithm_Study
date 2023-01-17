package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7569 {
	static class Node {
		int r, c, h, day;
		
		Node(int r, int c, int h,int day) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.day = day;
		}
	}
	static int R, C, H, result = 0;
	static int[][][] map;	// 층, 행, 열
	static boolean[][][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[] dh = {1, -1};
	
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		initStaticVariable(br.readLine());
		map = new int[H][R][C];
		visited = new boolean[H][R][C];
		
		for(int i=0 ; i<H ; i++) {
			for(int j=0 ; j<R ; j++) {
				map[i][j] = sToIntArr(br.readLine());
			}
		}
		
		while(true) {
			for(int h=0 ; h<H ; h++) {
				for(int r=0 ; r<R ; r++) {
					for(int c=0 ; c<C ; c++) {
						// 익은 토마토인 경우
						if(map[h][r][c] == 1 && !visited[h][r][c]) {
							q.offer(new Node(r, c, h, 0));
							visited[h][r][c] = true;
							
						}
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
		H = input[2];
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Node n = q.poll();

			for(int i=0 ; i<6 ; i++) {
				int nr, nc, nh;
				if(0<=i && i<=3) {
					nr = n.r + dr[i];
					nc = n.c + dc[i];
					nh = n.h;
				} else {
					nr = n.r;
					nc = n.c;
					nh = n.h + dh[i-4];
				}
				
				if(!in(nr, nc, nh) || !changePossible(nr, nc, nh) || visited[nh][nr][nc]) continue;
				
				visited[nh][nr][nc] = true;
				map[nh][nr][nc] = 1;
				q.offer(new Node(nr, nc, nh, n.day + 1));
				result = Math.max(result, n.day+1);
			}
			
		}
		
		
	}
	
	private static boolean in(int r, int c, int h) {
		return (0<=r && r<R) && (0<=c && c<C) && (0<=h && h<H);
	}
	
	private static boolean changePossible(int r, int c, int h) {
		return map[h][r][c] == 0;
	}
	
	private static boolean checkChangeFinish() {
		for(int h=0 ; h<H ; h++) {
			for(int r=0 ; r<R ; r++) {
				for(int c=0 ; c<C ; c++) {
					if(map[h][r][c] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
