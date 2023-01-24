package backtracking;

// BOJ 15655 N과 M (6)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_15655_N과M6 {
	static int N, M;
	static int[] numArr, arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[N];	// 입력받을 숫자 배열 
		arr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		back(0,0);
		System.out.println(sb);
		
		
	}
	
	static void back(int depth, int start) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start ; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = numArr[i];
				back(depth+1, i+1);			// 어렵다 ㅠㅠ 
											// 지금 넣은 숫자의 다음 숫자부터 for문이 돌도록 start 에 i+1을 대입 
				visited[i] = false;	
			}
		}
	}
}
