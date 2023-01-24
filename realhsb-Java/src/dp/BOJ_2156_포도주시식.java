package dp;

// BOJ 2156 - 포도주 시식 (DP)

/*  arr 배열 
 *  1 2 3
 *  O O X	DP[3] = DP[2]
 *  O X O			DP[1] + arr[3]
 *  X O O			
 *  
 *  
 *  
 *   DP[i]에 3가지 중에 하나 max 값 넣기 
 *   OOX : DP[i] = DP[i-1]
 *   OXO : DP[i] = DP[i-2] + arr[i]
 *   XOO : DP[i] = DP[i-3] + arr[i-1] + arr[i]
 *   	-> DP[i-3] 이 헷갈렸는데, DP[0] = 0을 해줄 것이기 때문에 괜찮다.
 *   
 *   
 */


import java.util.Scanner;

public class BOJ_2156_포도주시식 {
	static int n;			// 1 <= n <= 10000, n이 1일 때 예외처리 하기.
	static int[] arr;
	static int[] DP;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		arr = new int[n+1];
		DP = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
		}
		
		DP[1] = arr[1];
		
		if(n >= 2) {
			DP[2] = arr[1] + arr[2];	// n = 1일 때 예외처리 
		}
		
		for (int i = 3; i <= n; i++) {
			DP[i] = Math.max(Math.max(DP[i-1], DP[i-2] + arr[i]), DP[i-3]+ arr[i-1] + arr[i]);
		}
		
		System.out.println(DP[n]);
	}

}
