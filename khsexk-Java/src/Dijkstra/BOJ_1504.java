package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1504 {
	static int N, E;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
	
	static class Node implements Comparable<Node> {
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
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] NE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = NE[0];
		E = NE[1];
		
		for(int i=0 ; i<=N ; i++) adjList.add(new ArrayList<>());
		
		for(int i=0 ; i<E ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adjList.get(input[0]).add(new Node(input[1], input[2]));
			adjList.get(input[1]).add(new Node(input[0], input[2]));
		}
		
		int[] vertexs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int v1 = vertexs[0];
		int v2 = vertexs[1];
		
		int case1 = 0;
		case1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		
		int case2 = 0;
		case2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		
		int result = (case1>=200_000_000 && case2>=200_000_000) ? -1 : Math.min(case1, case2);
		
		System.out.println(result);
	}
	static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[N+1];
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, 200_000_000);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.idx] = true;
			
			for(Node adj : adjList.get(n.idx)) {
				if(!visited[adj.idx] && dist[adj.idx] > dist[n.idx] + adj.w) {
					dist[adj.idx] = dist[n.idx] + adj.w;
					pq.offer(new Node(adj.idx, dist[adj.idx]));
				}
			}
		}
		
		return dist[end];
	}
}
