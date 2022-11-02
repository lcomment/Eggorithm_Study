package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1138 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] seq = new int[N];  // 키를 저장할 테이블 
		
		// 키 리셋 
		Arrays.fill(seq, Integer.MAX_VALUE);
		
		for(int i=0 ; i<N ; i++) {
			int cnt = 0;
			int height = i+1;
			
			for(int j=0 ; j<N ; j++) {
				// 지금까지의 카운트가 나보다 큰 사람의 수와 같을 때 
				if(input[i] == cnt && seq[j] == Integer.MAX_VALUE) {
					seq[j] = height;
					break;
				}
				if(seq[j] > height)
					cnt++;
			}
		}
		
		for(int n : seq)
			System.out.println(n);
	}

}
