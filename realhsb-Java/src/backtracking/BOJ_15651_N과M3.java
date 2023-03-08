package backtracking;

// BOJ 15651 N과 M (3)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_15651_N과M3 {
	// 1부터 N까지 자연수 중에서 M개를 고른 수열
	// 같은 수를 여러 번 골라도 된다.
	public static int N, M;	// (1 ≤ M ≤ N ≤ 7)
	public static int[] arr;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		
		arr = new int[M];
		
		backtracking(0);
		
		System.out.println(sb);
	}
	
	static void backtracking(int depth) {
		if (depth == M) {
			for(int n : arr) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			backtracking(depth + 1);
		}
	}
}