package dfs_bfs;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class BOJ_12869_뮤탈리스크 {
	static int[][] arr = {{9,3,1}, {9,1,3}, {3,9,1}, {3,1,9}, {1,9,3}, {1,3,9}};
	static int[] SCV;
	static int min = Integer.MAX_VALUE;
	static int N;
	static boolean[][][][] field;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		field = new boolean[61][61][61][1];	// 처음에는 [61][61][61] 로 하다가 끝에 count 담을 칸 생성 
		
		SCV = new int[4];
		for(int i = 0; i < N; i++) {
			SCV[i] = scan.nextInt();
		}
		
		//System.out.println(Arrays.toString(SCV));
		
		BFS(SCV);
		System.out.println(min);
	}
	
	static void BFS(int[] scv) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(scv);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			//System.out.println("now : " + Arrays.toString(now));
			
			int x = now[0];
			int y = now[1];
			int z = now[2];
			int count = now[3];
			
			field[x][y][z][0] = true;
			count++;
			
			for(int i = 0; i < 6; i++) {
				// 0 보다 작으면 field의 index 범위를 벗어남 0 <= index < 61
				int x1 = Math.max(0, x - arr[i][0]);
				int y1 = Math.max(0, y - arr[i][1]);
				int z1 = Math.max(0, z - arr[i][2]);
				
				//System.out.println("\tcount :" + count);
				if(x1 == 0 && y1 == 0 && z1 == 0) {

					//System.out.println("\tadd : " + Arrays.toString(new int[] {x1, y1, z1, count}));
					min = Math.min(count, min);
				}
				
				else if((x1 >= 0|| y1 >= 0|| z1 >= 0) && field[x1][y1][z1][0] != true) {
					field[x1][y1][z1][0] = true;

					queue.add(new int[] {x1, y1, z1, count});
					//System.out.println("\tadd : " + Arrays.toString(new int[] {x1, y1, z1, count}));
				} 
				if(min < count) break;
			}
		}
	}
}

