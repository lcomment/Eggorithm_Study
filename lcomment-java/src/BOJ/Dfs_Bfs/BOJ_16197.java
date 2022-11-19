package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16197 {
	static class Node {
		int r, c, cnt;
		
		Node(int r, int c, int cnt){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int R, C;
	static char[][] map;
	static Node[] coin = new Node[2];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		R = input[0];
		C = input[1];
		map = new char[R][C];
		boolean flag = false;
		
		for(int i=0 ; i<R ; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0 ; j<C ; j++) {
				if(map[i][j] == 'o') {
					if(!flag) {
						coin[0] = new Node(i, j, 0);
						flag = !flag;
					} else {
						coin[1] = new Node(i, j, 0);
	 				}
				}
			}
		} // for_i
		
		System.out.println(bfs());
	}
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(coin[0]);
		q.offer(coin[1]);
		
		while(!q.isEmpty()) {
			Node n1 = q.poll();
			Node n2 = q.poll();
			
			if(n1.cnt + 1 > 10) return -1;
			
			for(int i=0 ; i<4 ; i++) {
				int nr1 = n1.r + dr[i];
				int nc1 = n1.c + dc[i];
				boolean flag1 = false;
				
				int nr2 = n2.r + dr[i];
				int nc2 = n2.c + dc[i];
				boolean flag2 = false;
				
				if(nr1<0 || nc1<0 || nr1>R-1 || nc1>C-1) flag1 = true;
				if(nr2<0 || nc2<0 || nr2>R-1 || nc2>C-1) flag2 = true;
				
				// 동시에 떨어지는 경우 
				if(flag1 && flag2) continue;
				
				// 하나가 떨어진 경우 
				if(flag1 || flag2) return n1.cnt + 1;
				
				// 둘다 벽에 부딪힌 경우 
				if(map[nr1][nc1] == '#' && map[nr2][nc2] == '#') continue;
				
				// coin1이 벽에 부딪힌 경우 
				if(map[nr1][nc1] == '#') {
					nr1 = n1.r;
					nc1 = n1.c;
				}
				// coin2이 벽에 부딪힌 경우
				if(map[nr2][nc2] == '#') {
					nr2 = n2.r;
					nc2 = n2.c;
				}
				
				q.offer(new Node(nr1, nc1, n1.cnt+1));
				q.offer(new Node(nr2, nc2, n2.cnt+1));
				
				System.out.println(nr1 + " " + nc1);
				System.out.println(nr2 + " " + nc2);
				System.out.println();
			}
		}
		return -1;
	}
}
