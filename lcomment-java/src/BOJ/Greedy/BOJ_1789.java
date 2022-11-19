package Greedy;

import java.util.Scanner;

public class BOJ_1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		
		long n = 0;
		long sum = 0;
		while(true) {
			sum += n;
			
			if(sum > S) break;
			
			n++;
		}
		
		System.out.println(n-1);
	}

}
