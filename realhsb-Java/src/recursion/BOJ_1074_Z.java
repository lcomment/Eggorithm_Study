package recursion;

// BOJ 1074 Z

/*
 * 1 ≤ N ≤ 15
 * 0 ≤ r, c < 2^N
 *  input : N, r, c
 */



/* 다시 다시 
 * (1) | (2)
 * (3) | (4)
 * 
 * 제1사분면 : size / 2 > r && size / 2 > c
 * 제2사분면 : size / 2 > r && size / 2 < c
 * 제3사분면 : size / 2 < r && size / 2 > c
 * 제4사분면 : size / 2 < r && size / 2 < c
 */

import java.util.Scanner;

public class BOJ_1074_Z {
	static int N, r, c, size, count;
	
	public static void main(String[] args) {
		init();
		find(size, r, c);
		System.out.println(count);
	}
	
	private static void init() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		r = scan.nextInt();	// 행 
		c = scan.nextInt();	// 열 
		size = (int) Math.pow(2, N); // 한 변의 사이즈 2^N
		count = 0; // 방문 횟수 초기
	}
	
	private static void find(int size, int r, int c) {
		if(size == 1) return;
		
		if (size/2 > r && size/2 > c) {  // (1)
			find(size/2, r, c);
			
		} else if(size/2 > r && size/2 <= c) {  // (2)
			count += (size * size) / 4;
			find(size/2, r, c - size/2);
			
		} else if(size/2 <= r && size/2 > c) {  // (3)
			count += (size * size/4)* 2;
			find(size/2, r - size/2, c);
			
		} else { // size / 2 < r && size / 2 < c   // (4)
			count += (size * size/4)* 3;
			find(size/2, r - size/2, c - size/2);
		}
		
	}
}
