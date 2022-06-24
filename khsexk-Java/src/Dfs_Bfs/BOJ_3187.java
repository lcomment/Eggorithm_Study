package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3187 {
	static char[][] map;
	static boolean[][] visited;
	static int[] data;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[] result = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		map = new char[data[0]][data[1]];
		visited = new boolean[data[0]][data[1]];
		
		// 입력 
		for(int i=0 ; i<data[0] ; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0 ; j<data[1] ; j++) {
				map[i][j] = input[j];
			}
		} // for_i
		
		for(int i=0 ; i<data[0] ; i++) {
			for(int j=0 ; j<data[1] ; j++) {
				if(map[i][j] != '#' && !visited[i][j])
					bfs(i, j);
			}
		} // for_i
		
		System.out.println(result[0] + " " + result[1]);
	}
	static void bfs(int x, int y) {
		int wolf = 0;
		int sheep = 0;
		
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x, y));
		visited[x][y] = true;
		if(map[x][y] == 'v')
			wolf++;
		if(map[x][y] == 'k')
			sheep++;
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=data[0] || ny>=data[1]) continue;
				
				if(map[nx][ny] != '#' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new Pair(nx, ny));
					
					if(map[nx][ny] == 'v')
						wolf++;
					if(map[nx][ny] == 'k')
						sheep++;
				}
			} // for_dxdy
		} // while_queue
		if(sheep > wolf) {
			result[0] += sheep;
		}
		else {
			result[1] += wolf;
		}
	}
}

//class Pair {
//	int x;
//	int y;
//	
//	Pair(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}