package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1238 {
	static class Edge implements Comparable<Edge>{
		int destination, time;
		
		Edge(int destination, int time) {
			this.destination = destination;
			this.time = time;
		}
		
		@Override
		public int compareTo(Edge o) {
			int result = this.time - o.time;
			
			return result;
		}
	}
	
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	static int N, M, X;
	static int[] times;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NMX = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NMX[0];
		M = NMX[1];
		X = NMX[2];
		
		for(int i=0 ; i<=N; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adjList.get(input[0]).add(new Edge(input[1], input[2]));
		}
		
		times = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			dijkstra(i);
		}
		
		int max = -1;
		for(int i=1 ; i<=N ; i++) {
			max = Math.max(max, times[i]);
		}
		System.out.println(max);
	}
	
	static void dijkstra(int idx) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(idx, 0));
		
		int[] dist = new int[N+1];
		dist[idx] = 0;
		boolean[] visited = new boolean[N+1];
		visited[idx] = true;
		
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if(e.destination == X && idx != X) {
				break;
			}
			
			for(Edge next : adjList.get(e.destination)) {
				if(visited[next.destination] && dist[next.destination] <= dist[e.destination] + next.time) continue;
				
				dist[next.destination] = dist[e.destination] + next.time;
				pq.offer(new Edge(next.destination, dist[next.destination]));
				visited[next.destination] = true;
			}
		} // while_pq
		
		if(idx == X) {
			for(int i=1 ; i<=N ; i++) {
				times[i] += dist[i];
			}
		} else {
			times[idx] += dist[X];
		}
	}

}
