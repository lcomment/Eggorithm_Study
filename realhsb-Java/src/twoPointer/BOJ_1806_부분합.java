package twoPointer;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
	static int N, S, sum, head, tail, ans;
	static int[] array;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		S = scan.nextInt();
		array = new int[N+1];
		sum = 0; head = 0; tail = 0;
		ans = 100_001;
		
		scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(scan.nextLine());
		
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		while(head <= N && tail <= N) {
			if(sum >= S) {
				ans = Math.min(ans,	tail - head);
			}
			
			if(sum < S) {
				sum += array[tail++];
				
			}else if(sum >= S) {
				sum -= array[head++];
			}
		}
		if(ans == 100_001) ans = 0;
		System.out.println(ans);
	}
}
