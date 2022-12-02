package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_15903 {
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NM[0];
		M = NM[1];
		
		int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int s : seq)
			pq.offer((long)s);
		
		while(M-- > 0) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			long sum = num1 + num2;
			System.out.println(sum);
			pq.offer(sum);
			pq.offer(sum);
		}
		
		long result = 0;
		while(!pq.isEmpty()) {
			result += pq.poll();
		}
		
		System.out.println(result);
	}

}
