package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {
	static String[] first = {"2", "3", "5", "7"};
	static String[] next = {"1", "3", "7", "9"};
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(String n : first) {
				backtracking(n, 1);
		}
	}
	static void backtracking(String s, int depth) {
		if(depth == N) {
			System.out.println(s);
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			String nextNum = s + next[i];
			
			if(isPrime(Integer.parseInt(nextNum)))
				backtracking(nextNum, depth + 1);
		} // for_i
	}
	
	static boolean isPrime(int num) {
		int cutline = (int)Math.sqrt(num);
		
		for(int i=2 ; i<=cutline ; i++) 
			if(num % i == 0) return false;
		
		return true;
	}
}
