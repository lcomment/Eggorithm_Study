package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15652 {
	static int N, M;
	static int[] num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		M = input[1];
		num = new int[M];
		
		backtracking(1, 0);
	}
	static void backtracking(int start, int depth) {
		if(depth == M) {
			for(int n : num)
				System.out.print(n + " ");
			System.out.println();
			return;
		}
		
		for(int i=start ; i<=N ; i++) {
			num[depth] = i; 
			backtracking(i, depth+1);
		}
	}
}
