package implementation;

// BOJ 2564 경비원 

import java.util.Scanner;

/*
 * 		1
 * 3		4
 * 		2		
 */		

public class BOJ_2564_경비원 {
	
	static int X, Y, stores, a, b, loc, ans;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		X = scan.nextInt();
		Y = scan.nextInt();
		stores = scan.nextInt();
		ans = 0;
		
		arr = new int[stores + 1];
		
		for (int i = 0; i < stores + 1; i++) {
			a = scan.nextInt();	// 방향 (동서남북)
			b = scan.nextInt();	// 거리  
			loc = 0;
			switch (a) {
				case 1 :	// 북 
					loc = b;
					break;
				case 2 :	// 남 
					loc = 2 * X + Y - b;
					break;
				case 3 :	// 서 
					loc = 2 * X + 2 * Y - b; 
					break;
				case 4 :	// 동 
					loc = X + b; 
					break;
			}
			arr[i] = loc;
		}
		
		int peri = 2 * X + 2 * Y;
		for (int i = 0; i < stores; i++) {
			int path1 = Math.abs(loc - arr[i]);
			int path2 = peri - path1;
			
			ans += Math.min(path1, path2);
		}
		System.out.println(ans);
	}
}
