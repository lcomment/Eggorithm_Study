package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15654 {
	static int N, M;
	static int[] input;
	static int[] num;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		num = new int[M];
		visited = new boolean[N];
		
		input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(input);
		
		backtracking(0);
	}
	static void backtracking(int depth) {
		if(depth == M) {
			for(int n : num)
				System.out.print(n + " ");
			System.out.println();
			return;
		}
		
		for(int i=0 ; i<N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[depth] = input[i];
				backtracking(depth + 1);
				visited[i] = false;
			}
		}
	}
}
