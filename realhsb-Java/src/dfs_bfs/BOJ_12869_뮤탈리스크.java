package dfs_bfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BOJ_12869_뮤탈리스크 {
	static int[][] arr = {{9,3,1}, {9,1,3}, {3,9,1}, {3,1,9}, {1,9,3}, {1,3,9}};	// 모든 경우의 수 
	static int[] SCV;			// 입력 받을 SCV
	static int min = Integer.MAX_VALUE;
	static int N;				// SCV 개수, 1 <= N <= 60
	static boolean[][][][] field;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		field = new boolean[61][61][61][1];	
		// 참고한 부분 - field의 사이즈, 처음에는 [3][3][3] -> [61][61][61]
		// 마지막 칸은 count를 담을 자리 추가해줌 
		
		SCV = new int[4];
		for(int i = 0; i < N; i++) {
			SCV[i] = scan.nextInt();
		}
		
		BFS(SCV);
		System.out.println(min);
	}
	
	static void BFS(int[] scv) {	// 너비우선탐색 
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(scv);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			int x = now[0];
			int y = now[1];
			int z = now[2];
			int count = now[3];
			
			field[x][y][z][0] = true;	// 방문 체크 
			
			// 실수 : count++를 for문 안에서 함  
			count++;
			
			for(int i = 0; i < 6; i++) {
				// 0 보다 작으면 field의 index 범위를 벗어남 0 <= index < 61
				int x1 = Math.max(0, x - arr[i][0]);
				int y1 = Math.max(0, y - arr[i][1]);
				int z1 = Math.max(0, z - arr[i][2]);
				
				
				if(x1 == 0 && y1 == 0 && z1 == 0) {	// 모든 원소가 0이 되면 min 값 구하기 
					min = Math.min(count, min);
				}
				
				else if((x1 >= 0|| y1 >= 0|| z1 >= 0) && field[x1][y1][z1][0] != true) {
					field[x1][y1][z1][0] = true;
					queue.add(new int[] {x1, y1, z1, count});
				} 
				if(min < count) break;	// count가 min을 넘을 경우 제외 
			}
		}
	}
}
