package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1941 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static char[][] map = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	static int[] selected = new int[7];
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0 ; i<5 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		combination(0, 0, 0);
		System.out.println(count);
	}
	static void combination(int start, int depth, int dasom) {
		if (depth == 7) {
			if(dasom >=4)
				bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;

            if (!visited[x][y]) {
            	visited[x][y] = true;
            	
            	selected[depth] = i;
            	if(map[x][y] == 'S') combination(i + 1, depth + 1, dasom+1);
            	else combination(i + 1, depth + 1, dasom);
            	
                visited[x][y] = false;
            }
        }
	}
	static void bfs() {
		boolean[][] sVisited = new boolean[5][5];
		Queue<Integer> q = new LinkedList<>();
		q.offer(selected[0]);
		
		int dasom = 1;
		
		while(!q.isEmpty()) {
			int s = q.poll();
			sVisited[s / 5][s % 5] = true;
			
			for(int i=0 ; i<4 ; i++) {
				int nx = dx[i] + s / 5;
				int ny = dy[i] + s % 5;
				
				if(nx < 0 || ny < 0 || nx > 4 || ny > 4 || !visited[nx][ny] || sVisited[nx][ny]) continue;
				
				dasom++;
				q.offer(nx*5 + ny);
				sVisited[nx][ny] = true;
			} // for
		} // while
		
		if(dasom == 7) count++;
	}
}