package dp;

// BOJ - 13301번 타일 장식물 (76점 / 100점)

import java.util.Scanner;

public class BOJ_13301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long E[] = new long[81];
		long D[] = new long[81];
		
		E[1] = 1;
		E[2] = 1;
		
		for(int i = 3; i <= 80; i++) {
			E[i] = E[i-1] + E[i-2];
		}
		
		D[1] = 4 * E[1];
		for(int i = 2; i <= 80; i++) {
			D[i] = D[i-1] + 2*E[i];
		}
		System.out.println(D[N]);
	}
}
