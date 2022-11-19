package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1388 {
	static boolean[][] visited;
	static char[][] map;
	static int N, M , cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = NM[0];
		M = NM[1];
		visited = new boolean[N][M];
		map = new char[N][M];
		
		for(int i=0 ; i<N ; i++) {
			char[] input = br.readLine().toCharArray();
			map[i] = input;
		}
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<M ; j++) {
				if(!visited[i][j]) bfs(i, j);
			}
		}
		System.out.println(cnt);
	}
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		
		char d = map[r][c];
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nr = p.r + 1;
			int nc = p.c + 1;
			
			if(d == '|') {
				if(nr>=N || visited[nr][c] || map[nr][c] == '-') continue;
				
				q.offer(new Point(nr, c));
				visited[nr][c] = true;
			}
			else if(d == '-') {
				if(nc>=M || visited[r][nc] || map[r][nc] == '|') continue;
				
				q.offer(new Point(r, nc));
				visited[r][nc] = true;
			}
		} // while-q
		cnt++;
	}
}
class Point{
	int r;
	int c;
	Point(int r, int c){
		this.r = r;
		this.c = c;
	}
}