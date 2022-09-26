package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1753 {
	static class Node implements Comparable<Node>{
		int idx, w;
		
		Node(int idx, int w){
			this.idx = idx;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.w - n.w;
		}
	}
	static int V, E, K;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		V = VE[0];
		E = VE[1];
		K = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0 ; i<=V ; i++)
			adjList.add(new ArrayList<>());
		
		for(int i=0 ; i<E ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adjList.get(input[0]).add(new Node(input[1], input[2]));
		}
		
		dijkstra();
		
		for(int i=1 ; i<=V ; i++) {
			if(dist[i] != Integer.MAX_VALUE)
				System.out.println(dist[i]);
			else
				System.out.println("INF");
		}
	}
	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		dist[K] = 0;
		visited[K] = true;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			for(Node next : adjList.get(n.idx)) {
				if(visited[next.idx] && dist[next.idx] <= dist[n.idx] + next.w) continue;
				
				dist[next.idx] = dist[n.idx] + next.w;
				pq.offer(new Node(next.idx, dist[next.idx]));
				visited[next.idx] = true;
			} // for-each
		} // while_pq
	}
}
