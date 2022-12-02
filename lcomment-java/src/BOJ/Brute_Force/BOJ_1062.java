package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class BOJ_1062 {
	static int N, K, result = 0;
	static char ch = 'a';
	static String[] words;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = NK[0];
		K = NK[1];
		words = new String[N];
		visited = new boolean[26];
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		else if(K==26){
			System.out.println(N);
			return;
		}
		K -= 5;
		visited['a' - ch] = true;
		visited['n' - ch] = true;
		visited['t' - ch] = true;
		visited['i' - ch] = true;
		visited['c' - ch] = true;
		
		
		for(int i=0 ; i<N ; i++) {
			String input = br.readLine(); 
			
			input.replace("anta", "");
			input.replace("tica", "");
			words[i] = input;
		}
		
		backtracking(0, 0);
		
		System.out.println(result);
	}
	
	static void backtracking(int idx, int depth) {
		if(depth == K) {
			int cnt = 0;
			
			for(int i=0 ; i<N ; i++) {
				boolean flag = true;
				for(int j=0 ; j<words[i].length() ;j++) {
					if(!visited[words[i].charAt(j) - ch]) {
						flag = false;
						break;
					}
				}
				if(flag)
					cnt++;
			}
			
			result = result < cnt ? cnt : result;
			return;
		}
		
		for(int i=idx ; i<26 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtracking(i, depth + 1);
				visited[i] = false;
			}
		}
	}
}
