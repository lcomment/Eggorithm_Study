package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1012 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			map = new int[input[0]][input[1]];
			
			for(int i=0 ; i<input[2] ; i++) {
				int[] napa = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				map[napa[0]][napa[1]] = 1;
			} //for_i
			
			int earthwarm = 0;
			
			for(int i=0 ; i<input[0] ; i++) {
				for(int j=0 ; j<input[1] ; j++) {
					if(map[i][j] == 1) {
						bfs(new Node(i, j));
						earthwarm++;
					}
				}
			}
			sb.append(earthwarm + "\n");
		} // while
		
		System.out.println(sb.toString());
	}
	
	static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		map[start.r][start.c]--;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > map.length-1 || nc > map[0].length-1) continue;
				
				if(map[nr][nc] == 1) {
					map[nr][nc]--;
					q.offer(new Node(nr, nc));
				}
			} // for
		} // while
	}
}
