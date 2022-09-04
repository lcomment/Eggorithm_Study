package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559 {
	static class Node {
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static char[][] map = new char[12][6];
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static int start = 0;
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0 ; i<12 ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int c = 1;
		while(true) {
			boolean flag = false;
			int cnt = 0;
			
			for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) 
                    if(map[i][j] != '.') {
                    	flag = bfs(i, j);

                    	if(flag)
                    		cnt++;
                    }
			}
			
			if(cnt == 0)
				break;
			
			puyo();
			count++;
		}
		
		System.out.println(count);
	}
	static boolean bfs(int r, int c) {
		boolean[][] visited = new boolean[12][6];
		visited[r][c] = true;
		
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> puyoList = new ArrayList<>();
		q.offer(new Node(r, c));
		puyoList.add(new Node(r,c));
		
		int condition = 1;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			for(int i=0 ; i<4 ; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > 11 || nc > 5) continue;
				
				if(!visited[nr][nc] && map[nr][nc] == map[r][c]) {
					q.offer(new Node(nr, nc));
					puyoList.add(new Node(nr,nc));
					visited[nr][nc] = true;
					condition++;
				}
			} // for
			

		} // while
		
		if(condition >= 4) {
			for(Node n : puyoList)
				map[n.r][n.c] = '.';
			
			return true;
		}
		return false;
	}
	
	static void puyo() {
		for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                        	map[j][i] = map[k][i];
                        	map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
	}
}
