//보류
package chapter2;

import java.util.*;
import java.io.*;

	class pos{
		int x;
		int y;
		
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	class TypeInference{
		static String[][] map;
		static boolean[] visited;
		static int cnt = 0;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			map = new String[5][5];							// map
			for(int i=0; i<5 ;i++) {
				String[] temp = br.readLine().split("");
				for(int j=0; j<5; j++) {
					map[i][j] = temp[j];
				}
			}
         //이차원 배열을 일차원 배열로 표현
         visited = new boolean[25];
         comb(0,7);
         
   
         System.out.println(cnt);
    }
	private static void comb(int start, int r) {			//조합 
		if(r==0) {
			int num=0;
			int temp=0;
			int x=0;
			int y=0;
			int[][] map2 = new int[5][5];  	//선택한 자리를 위한 배열
			for(int i=0; i<25; i++) {		//row와 col로 변환
				int row = i/5;
				int col = i%5;
				if(visited[i]) {
					map2[row][col] = 1;		//선택한 자리
					if(temp==0) {
						x=row;
						y=col;
					}
											//다솜쪽 몇명인지 확인
					if(map[row][col].equals("S")) {
						num++;
					}
					temp++;
				}
				if(temp==7) 				//7명이라면 끝 
					break;
			}
			if(num>=4) {
				bfs(x,y,map2);
			}
			return;
		}
		for(int i=start; i<25; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(i+1, r-1);
				visited[i]=false;
			}
		}
	}
    
	private static void bfs(int a, int b, int[][] arr) {
		Queue<pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		int[] xdir = {-1,1,0,0};
		int[] ydir = {0,0,-1,1};
		
		q.offer(new pos(a,b));
		visited[a][b] = true;
		int num = 1;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i=0; i<4; i++) {
				int dx = x+ xdir[i];
				int dy = y+ ydir[i];
				//유효한 위치 && 선택된자리 && 방문하지 않은 자리 
				if(isValidPosition(dx,dy) && arr[dx][dy] == 1 && !visited[dx][dy]) {
					q.offer(new pos(dx,dy));
					visited[dx][dy] = true;
					num++;
				}
			}
		}
		if(num==7)
			cnt++;
	}
	private static boolean isValidPosition(int x, int y) {			//범위내에 있는지 확인 
		if(x<0 || y<0 || x>=5|| y>=5) return false;
		return true;
	}

}
