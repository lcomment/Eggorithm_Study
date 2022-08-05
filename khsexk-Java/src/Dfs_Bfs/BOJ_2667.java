package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
	static int N;
	static char[][] map;
	static int count = 0;
	static ArrayList<Integer> cntList = new ArrayList<>();
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0 ; i<N ; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int r=0 ; r<N ; r++) {
			for(int c=0 ; c<N ; c++) {
				if(map[r][c] == '1')
					bfs(r, c);
			}
		}
		
		System.out.println(count);
		
		Collections.sort(cntList);
		
		for(int cnt : cntList)
			System.out.println(cnt);
	}
	
	public static void bfs(int r, int c) {
		cntList.add(1);
		map[r][c] = '2';
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				if(nr<0 || nc<0 || nr>N-1 || nc>N-1)
					continue;
				
				if(map[nr][nc] == '1') {
					map[nr][nc] = '2';
					cntList.set(count, cntList.get(count) + 1);
					queue.offer(new Node(nr, nc));
				}
			} // for_i
		} // while
		count++;
	}

}

class Node {
	int r;
	int c;
	
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
}
