package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2933 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C, N;
	static char[][] map;
	static int[] throwing;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		R = input[0];
		C = input[1];
		map = new char[R][C];
		
		for(int i=0 ; i<R ; i++)
			map[i] = br.readLine().toCharArray();
		
		N = Integer.parseInt(br.readLine());
		throwing = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		boolean flag = true;
		
		for(int thr : throwing) {
			int n = R - thr;
			
			if(crush(n, flag)) {
				ArrayList<Node> minerals = bfs();
				
				if(minerals.size() != 0) {
					drop(minerals);
				}
			}
			
			flag = !flag;
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0 ; j<C ; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
	}
	static boolean crush(int h, boolean d) {
		if(d) {
			for(int i=0 ; i<C ; i++) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					return true;
				}
			} // for_i
		}
		else {
			for(int i=C-1 ; i>=0 ; i--) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					return true;
				}
			} // for_i
		}
		return false;
	}
	
	static ArrayList<Node> bfs() {
		boolean[][] visited = new boolean[R][C];
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0 ; i<C ; i++) {
			if(map[R-1][i] == 'x') {
				q.offer(new Node(R-1, i));
				visited[R-1][i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc <0 || nr > R-1 || nc > C-1) continue;
				
				if(map[nr][nc] == 'x' && !visited[nr][nc]) {
					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			} // for
		} // while_q
		
		ArrayList<Node> arr = new ArrayList<>();
		
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				if(map[i][j] == 'x' && !visited[i][j])
					arr.add(new Node(i, j));
			}
		}
		
		return arr;
	}
	
	// 검색함 
	static void drop(ArrayList<Node> minerals) {
		int cnt = 0;
		
		for(Node n : minerals) {
			map[n.r][n.c] = '.';
		}
		
		loop: 
		for(int i=0 ; i < R ; i++) {
			for(Node n : minerals) {
				if(n.r + i >= R || map[n.r + i][n.c] == 'x') {
					break loop;
				}
			}
			cnt = i;
		}
		
		for(Node n : minerals) {
			map[n.r + cnt][n.c] = 'x';
		}
	}
}
