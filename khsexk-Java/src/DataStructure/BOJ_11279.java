package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
	
		while(N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				System.out.println( pQueue.isEmpty() ? 0:pQueue.poll() );
			} else {
				pQueue.offer(input);
			}
		} // while
	}
}
