package dp;

// BOJ 9252 LCS 2 

/*
 * LCS(Longest Commen Sequence)
 */

import java.util.Scanner;

public class BOJ_9252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		char[] cArr1 = sc.nextLine().toCharArray();
		char[] cArr2 = sc.nextLine().toCharArray();
		int[][] A = new int[cArr1.length+1][cArr2.length+1];
		
		for(int i = 1; i < cArr1.length + 1; i++) {
			for(int j = 1; j < cArr2.length + 1; j++) {
				if(cArr1[i-1] == cArr2[j-1]) {
					A[i][j] = A[i-1][j-1] + 1;
				}else {
					A[i][j] = Math.max(A[i-1][j], A[i][j-1]);
				}
			}
		}
		
		int last = A[cArr1.length][cArr2.length];
		
		int i = A.length - 1;
		int j = A[0].length - 1;
		
		while(true) {
			
			
			if(A[i][j] == 0) break;
			if(A[i-1][j] == last) {
				last = A[--i][j];
			}else if(A[i][j-1] == last) {
				last = A[i][--j];
			}else {
				last = A[--i][--j];
				sb.append(cArr1[i]);
			}
		}
		System.out.println(A[cArr1.length][cArr2.length]);
		System.out.println(sb.reverse().toString());
		
	}
}