package backtracking;

// BOJ 16938 캠프준비
/*
 * 조합(Combination) 사용하기
 * 모든 경우의 수를 따져서 
 * 
 * <문제 조건>
 *  문제 수 N개
 *  L <= 문제 난이도 총합 <= R
 *  (가장 어려운 문제 난이도 - 가장 쉬운 문제 난이도) >= X
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_16938_캠프준비 {
	static int N, L, R, X;	// N : 문제 개수, L : 
	static int[] problems;
	static boolean[] visited;
	static int max, min, sum, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		count = 0;
		sum = 0;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
//		System.out.println("N : "+ N + " L : "+ L + " R : "+ R + " X : "+ X);
		
		problems = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			problems[i] = Integer.parseInt(st.nextToken());
		}
		
		// 문제는 2문제 이상!
		for(int i = 2; i <= N; i++) {
			combination(0, N, i);
		}
		
		System.out.println(count);
		
	}
	
	static void combination(int start, int n, int r) {
		if(r == 0) {
//			System.out.println("check!");
			check();
			return;
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination(i + 1, n, r - 1);
			visited[i] = false;
		}
	}
	
	static void check() {
		
//		for(int i = 0; i < N; i++) {
//			if(visited[i]) System.out.print(problems[i] + " ");
//		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		sum = 0;
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				sum += problems[i];
				if(max < problems[i]) max = problems[i];
				if(min > problems[i]) min = problems[i];
			}
		}
		
//		System.out.println("sum : " + sum + " max : " + max + " min : " + min);
		if((sum >= L && sum <= R) && ((max - min) >= X)) {
			count++;
		}
	}
}
