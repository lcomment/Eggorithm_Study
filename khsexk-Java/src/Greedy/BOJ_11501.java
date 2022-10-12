package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11501 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			long max = input[N-1];
			int idx = N-1;
			long sum = 0;
			
			for(int i=N-2 ; i>=0 ; i--) {
				if(max <= input[i]) {
					if(idx - i > 1) {
						for(int j=i+1 ; j<idx ; j++) {
							sum += max - input[j];
						}
					}
					max = input[i];
					idx = i;
				}
			}
			
			if(idx != 0) {
				for(int j=0 ; j<idx ; j++) {
					sum += max - input[j];
				}
			}
			System.out.println(sum);
		}
		
	}
}
