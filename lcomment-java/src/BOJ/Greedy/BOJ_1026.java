package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1026 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		
		String[] input = br.readLine().split(" ");
		for(int i=0 ; i<N ; i++)
			A[i] = Integer.parseInt(input[i]);
		Arrays.sort(A);
		
		input = br.readLine().split(" ");
		for(int i=0 ; i<N ; i++)
			B[i] = Integer.parseInt(input[i]);
		Arrays.sort(B);
		
		int sum = 0, idx = N-1;
		for(int i=0 ; i<N ; i++) {
			sum += A[idx]*B[i];
			idx--;
		}
		System.out.println(sum);
	}

}
