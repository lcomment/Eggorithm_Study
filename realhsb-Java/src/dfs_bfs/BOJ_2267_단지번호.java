package dfs_bfs;

// BOJ 2267 단지번호붙이기 

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2267_단지번호 {
	static boolean[][] visited;
	static int N;
	static char[][] field;
	static int answer;
	static int count;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		N = sc.nextInt();		// 지도의 크기 N(정사각형)
		
		sc.nextLine();
		field = new char[N][N];
		for(int i = 0; i < N; i++) {
			field[i] = sc.nextLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		count = 0;
		answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					if(field[i][j] == '1') {	// 1일 경우에만 DFS 진행 
						count = 0;
						answer++;				// 새로 DFS를 진행할 때, 구역 개수 증가 
						DFS(i, j);
						list.add(count);
					}
				}
			}	
		}
		
		Collections.sort(list);		// 오름차순 정리 
		System.out.println(answer);
		for(int l : list) {
			System.out.println(l);
		}
	}	// End of main
	
	static void DFS(int i, int j) {
		visited[i][j] = true;
		count++;
		for(int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if(x < N && y < N && x >= 0 && y >= 0) {	// 다음 칸의 범위 확인 	
				if(!visited[x][y] && field[x][y] == '1') {	
					// 범위에 포함된다면 다음칸 이 이미 방문한 칸인지, 1인지 확인 
					DFS(x, y);
				}
			}
		}
		return;
	}	// End of DFS
}	// End of class
