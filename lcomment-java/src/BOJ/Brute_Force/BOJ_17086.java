package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17086 {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, -1, 1, 0, -1, 0 ,1};
	static int[] dc = {-1, 1, 1, -1, -1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		map = new int[N][M];
		
		for(int i=0 ; i<N ; i++) 
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(map[i][j] == 1)
					bfs(i, j);
			}
		}
		
		int result = 0;
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) 
				result = Math.min(result, map[i][j]);
		}
		System.out.println(Math.abs(result));
	}
	
	static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(r, c));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<8 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > N-1 || nc > M-1 || map[nr][nc] == 1) {
					continue;
				}
				
				int d = map[n.r][n.c] == 1 ? -1 : map[n.r][n.c] - 1;
				
				if(map[nr][nc] == 0) {
					map[nr][nc] = d;
					q.offer(new Node(nr, nc));
				}
				else if(map[nr][nc] < d) {
					map[nr][nc] = d;
					q.offer(new Node(nr, nc));
				}
			} //for
		} // while
	}
	
	static class Node {
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
