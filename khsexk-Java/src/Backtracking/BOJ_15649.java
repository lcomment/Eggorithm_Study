package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15649 {
	static int N, M;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		
		num = new int[M];
		visited = new boolean[N];
		
		backtracking(num, visited, 0);
	}
	static void backtracking(int[] arr, boolean[] visited, int cnt) {
		if(cnt == M) {
			for(int n : arr)
				System.out.print(n + " ");
			System.out.println();
			
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = i + 1;
				backtracking(arr, visited, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
