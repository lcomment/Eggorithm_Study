package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_13549 {
	static int N, K, minTime = Integer.MAX_VALUE;
	static int[] times = new int[100_001];
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		K = input[1];
		
		Arrays.fill(times, Integer.MAX_VALUE);
		dijkstra();
		
		System.out.println(times[K]);
	}
	static void dijkstra(){
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		pQueue.offer(new Node(N, 0));
		times[N] = 0;
		
		while(!pQueue.isEmpty()) {
			Node n = pQueue.poll();
			
			int[] move = {n.p-1, n.p+1, n.p*2};
			
			for(int i=0; i<3 ; i++) {
				if(move[i] < 0 || move[i] > 100000 || n.time >= times[move[i]]) continue;
				
				if(i < 2) {
					times[move[i]] = n.time + 1;
					pQueue.offer(new Node(move[i], n.time+1));
				}
				else {
					times[move[i]] = n.time;
					pQueue.offer(new Node(move[i], n.time));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int p;
		int time;
		
		Node(int p, int time){
			this.p = p;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}
