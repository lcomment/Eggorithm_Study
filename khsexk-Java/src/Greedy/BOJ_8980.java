package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_8980 {
	static class Delivery implements Comparable<Delivery>{
		int start, end, cnt;
		Delivery(int start, int end, int cnt){
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Delivery d) {
			int result = this.end - d.end;
			
			if(result == 0)
				return this.start - d.start;
			return result;
		}
	}
	
	static int N, C, M, total = 0;;
	static ArrayList<Delivery> deliveries = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NC[0];
		C = NC[1];
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			deliveries.add(new Delivery(input[0], input[1], input[2]));
		}
		Collections.sort(deliveries);
		
		int[] boxCount = new int[N+1];
		Arrays.fill(boxCount, C);
		
		for(Delivery delivery : deliveries) {
			int start = delivery.start;
			int end = delivery.end;
			int cnt = delivery.cnt;
			int maxCount = Integer.MAX_VALUE;
			
			for(int i=start ; i<end ; i++) {
				maxCount = Math.min(maxCount, boxCount[i]);
			}
			
			if(maxCount >= cnt) {
				for(int i=start ; i<end ; i++) {
					boxCount[i] -= delivery.cnt;
				}
				total += delivery.cnt;
			} else {
				for(int i=start ; i<end ; i++) {
					boxCount[i] -= maxCount;
				}
				total += maxCount;
			}
		}
		
		System.out.println(total);
	}

}


