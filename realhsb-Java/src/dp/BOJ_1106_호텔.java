package dp;

// BOJ 1106 호텔 

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1106_호텔 {
	
	static int C, N;
	static int[] costs;
	static int[][] data;
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		C = scan.nextInt();	// 최소 고객 수 
		N = scan.nextInt();	// 홍보 가능한 도시 수 
		
		data = new int[N][2];
		costs = new int[C + 100];	// 최소 고객 C명이므로 C+100까지 확인해야 한다.
		
		for (int i = 0; i < N; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			data[i][0] = a;	// cost : 홍보 비용 
			data[i][1] = b;	// cus : 홍보로 증가하는 고객 수 
		}
		
		Arrays.sort(data, (o1, o2) -> {	// 홍보 비용을 기준으로 오름차순 정렬 
			return o1[0] - o2[0];
		});
		
		Arrays.fill(costs, INF);	// INF로 초기화
		
		
		costs[0] = 0;	// 고객 0명을 홍보하는 데 드는 비용 0원 
		
		for (int i = 0; i < N; i++) {
			int cost = data[i][0];
			int cus = data[i][1];
			for (int j = cus; j < C + 100; j++) {
				costs[j] = Math.min(costs[j], costs[j - cus] + cost);
			}
		}
		
		int ans = INF;
		for (int i = C; i < C + 100; i++) {
			ans = Math.min(ans, costs[i]);
		}
		
		System.out.println(ans);
	}
}
