package BellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_11657 {
	static class Edge{
		int start, end, weight;
		
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static int V, E, K;
	static ArrayList<Edge> edges = new ArrayList<>();
	static long[] dist;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		V = VE[0];
		E = VE[1]; 
		
		dist = new long[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0 ; i<E ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			edges.add(new Edge(input[0], input[1], input[2]));
		}
		
		boolean nagativeCycle = bellmanFord();
		
		if(nagativeCycle)
			System.out.println(-1);
		else {
			for(int i=2 ; i<=V ; i++) {
				if(dist[i] != Integer.MAX_VALUE)
					System.out.println(dist[i]);
				else
					System.out.println(-1);
			}
		}
	}
	static boolean bellmanFord() {
		dist[1] = 0;
		
		for(int i=0 ; i<V-1 ; i++) {
			for(Edge e : edges) {
				if(dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.weight) {
					dist[e.end] = dist[e.start] + e.weight;
				}
			} // for-Each
		} // for_i
		
		for(Edge e : edges) {
			if(dist[e.start] != Integer.MAX_VALUE && dist[e.end] > dist[e.start] + e.weight) 
				return true;	
		}
		
		return false;
	}
}
