package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1049 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NM[0];
		int M = NM[1];
		
		int six = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;
		
		for(int i=0 ; i<M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			six = six <= input[0] ? six : input[0];
			one = one <= input[1] ? one : input[1];
		}
		int sum = 0;
			
		int d = N / 6;
		int v = N % 6;
			
		if(six <= one*6) {
			sum += six*d;
			
			if(six <= one*v)  sum += six;
			else  sum += one*v;
		}
		else {
			sum += one*N;
		}
		System.out.println(sum);
	}

}
