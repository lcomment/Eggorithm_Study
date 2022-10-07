package dfs_bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_3197_백조의호수 {
	static int R, C, cur = 0, nxt = 1;		// water[cur] == 얼음을 녹게 한 물, water[nxt] == 얼음이 녹은 물 
	static char[][] field;					// 입력 받을 field 
	static boolean[][] swanVst, iceVst;		// 백조 방문 여부, 새로 얼음이 녹았는지 여부 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Queue<Point>[] swans;			// swans[0] == 
	static Queue<Point>[] water;			// water[cur] == 얼음을 녹게 한 물, water[nxt] == 얼음이 녹은 물 
	static Point[] swan;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);

		field = new char[R][C];
		swanVst = new boolean[R][C];
		iceVst = new boolean[R][C];
		
		water = new LinkedList[2];
		water[0] = new LinkedList<>(); 	// == water[cur]	얼음을 녹게 한 물
		water[1] = new LinkedList<>();	// == water[nxt] 	얼음이 녹은 물
		
		swans = new LinkedList[2];
		swans[0] = new LinkedList<>();
		swans[1] = new LinkedList<>();
		
		swan = new Point[2];
		
		int s = 0;
		
		for(int i = 0; i < R; i++) {
			field[i] = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				
				if(field[i][j] == 'L') {
					swan[s++] = new Point(i, j);
					field[i][j] = '.';
				}
				
				if(field[i][j] == '.') {
					water[0].add(new Point(i, j));
				}
			}
		}
		
		int count = 0;
		
		/*
		 *  초반에 swans에 첫 번째 백조 위치를 안 담아둬서 무한 루프에 빠짐
		 *  첫 번째 백조의 방문 체크  
		 */
		swans[0].add(swan[0]);
		swanVst[swan[0].x][swan[0].y] = true;
		
		// 참고 (1)
		while(true) {
			if(isMeeting()) break;
			melts();
			
			// cur와 nxt를 0, 1 번갈아가면서 바꿔줌
			cur ^= 1;
			nxt ^= 1;
			count++;
		}
		
		System.out.println(count);
	}
	
	static void melts() {
		while(!water[cur].isEmpty()) {
			Point now = water[cur].poll();
			// 얼음이 녹은 곳 방문 체크 
			iceVst[now.x][now.y] = true;
			for(int i = 0; i < 4; i++) {
				int x1 = now.x + dx[i];
				int y1 = now.y + dy[i];
				
				// 이미 얼음이 녹은 곳이나 백조가 방문한 곳은 continue로 넘어감 
				if(x1 < 0 || y1 < 0 || x1 >= R || y1 >= C || iceVst[x1][y1] || swanVst[x1][y1]) continue;	// 범위 
				if(field[x1][y1] == 'X') {
					// 물과 닿아있는 얼음(X)를 물(.)로 녹이기
					// 녹은 물(.) 큐에 담기, nxt에 담아두고 다음에 녹일 때 기준으로 삼음  
					// 물이 된 곳 방문 체크 
					field[x1][y1] = '.';
					water[nxt].add(new Point(x1, y1));
					iceVst[x1][y1] = true;
				}
			}
		}
	}
	
	static boolean isMeeting() {
		while(!swans[cur].isEmpty()) {
			Point now = swans[cur].poll();
			swanVst[now.x][now.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int x1 = now.x + dx[i];
				int y1 = now.y + dy[i];
				
				// 이미 백조가 방문했던 곳은 continue
				if (x1 < 0 || y1 < 0 || x1 >= R || y1 >= C || swanVst[x1][y1]) continue;	// 범위
				
				// 2번째 백조의 위치와 동일하면 return true
				if (swan[1].x == x1 && swan[1].y == y1) return true;
				
				// 백조 방문 체크 
				swanVst[x1][y1] = true;
				
				 
				// 참고 (2)
				if (field[x1][y1] == 'X') {
					// 만난 곳이 얼음(X)이라면 다음에 백조가 시작할 위치로 지정
					swans[nxt].add(new Point(x1, y1));
					// 물로 바꿔줌 
					field[x1][y1] = '.';
				} else {
					// 만난 곳이 물(.)이라면 현재 백조가 갈 수 있는 Point를 더해줌 
					swans[cur].add(new Point(x1, y1));
				}
			}
		}
		
		return false;
	}
	
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}