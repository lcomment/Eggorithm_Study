package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> cards = new PriorityQueue<>();
		
		for(int i=0 ; i<N ; i++) 
			cards.offer(Integer.parseInt(br.readLine()));
		
		int cnt = 0;

		while(cards.size() != 1) {
			if(cards.size() >= 2) {
				int sum = cards.poll() + cards.poll();
				cnt += sum;
				cards.offer(sum);
			}
		}
		System.out.println(cnt);
	}
}