package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2847 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		for(int i=0 ; i<N ; i++)
			input[i] = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		} else if(N == 2 && input[0] >= input[1]) {
			System.out.println(input[0] - input[1] + 1);
			System.exit(0);
		}
		
		int cnt = 0;
		int max = input[N-1];
		for(int i=N-2 ; i>=0 ; i--) {
			if(max <= input[i]) {
				int gap = input[i] - max + 1;
				cnt += gap;
				input[i] -= gap;
				max = input[i];
			}
			max = input[i];
			
		}
		System.out.println(cnt);
	}

}
