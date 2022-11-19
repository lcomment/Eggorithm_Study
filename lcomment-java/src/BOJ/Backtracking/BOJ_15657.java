package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15657 {
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
		
		backtracking(0, 0);
	}
	static void backtracking(int start, int depth) {
		if(depth == M) {
			for(int n : num)
				System.out.print(n + " ");
			System.out.println();
			return;
		}
		
		for(int i=start ; i<N ; i++) {
			if(depth != 0) {
				if(num[depth-1] <= input[i]) {
					visited[i] = true;
					num[depth] = input[i];
					backtracking(start, depth + 1);
					visited[i] = false;
				}
			} else {
				num[depth] = input[i];
				backtracking(start, depth + 1);
			}
		}
	}
}
