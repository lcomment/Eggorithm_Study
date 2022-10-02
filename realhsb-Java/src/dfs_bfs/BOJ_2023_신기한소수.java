package dfs_bfs;

import java.util.Scanner;

public class BOJ_2023_신기한소수 {
	static int N = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	static void DFS(int n, int index) {
		if (index == N) {
			if(isPrime(n)) {
				System.out.println(n);
			}
			return;
		}
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			
			if(isPrime(n * 10 + i)) {
				DFS(n * 10 + i, index+1);
			}
		}
	}
	
	static boolean isPrime(int n) {
		for(int i = 2; i <= n/2; i++) {
			if(n % i == 0) return false;
		}
		return true;
	}
}
