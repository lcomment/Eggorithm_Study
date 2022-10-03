package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806 {
	static int N, S;
	static int[] prefix;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		S = input[1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		prefix = new int[N+1];
		
		for(int i=0; i<N ; i++) {
			prefix[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0; 
		int sum = 0;
		while(start <= end && end <= N) {
			if(sum < S)
				sum += prefix[end++];
			else {
				min = Math.min(min, end-start);
				sum -= prefix[start++];
			}
		}
		
		if(min == Integer.MAX_VALUE)
       		System.out.println(0);        
        else
       		System.out.println(min);
	}

}
