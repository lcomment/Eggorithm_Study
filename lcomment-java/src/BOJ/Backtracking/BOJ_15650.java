package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15650 {
	static int N, M;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		
		num = new int[N];
		visited = new boolean[N];
		
		for(int i=0 ; i<N ; i++) 
			num[i] = i + 1;
		
		backtracking(num, visited, 0, 0);
	}
	static void backtracking(int[] arr, boolean[] visited, int start, int cnt) {
		if(cnt == M) {
			print(visited);
			return;
		}
		
		for(int i=start ; i<N ; i++) {
			visited[i] = true;
			backtracking(arr, visited, i+1, cnt + 1);
			visited[i] = false;
		}
	}
	static void print(boolean[] visited) {
		for(int i=0 ; i<visited.length ; i++) {
			if(visited[i]) {
				System.out.print(num[i] + " ");
			}
		}
		System.out.println();
	}
}
