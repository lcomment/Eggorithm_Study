package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1916 {
	static int N, M;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int[] dist = new int[N+1];
		int[] checked = new int[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0 ; i<=N ; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<M ; i++) {
			int[] bus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adjList.get(bus[0]).add(new Node(bus[2], bus[1]));
		}
		
		int[] condition = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		System.out.println(dijkstra(condition[0], condition[1], dist));
	}
	
	public static int dijkstra(int start, int end, int[] dist) {
		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		boolean[] checked = new boolean[N+1];
		
		pQueue.offer(new Node(0, start));
		dist[start] = 0;
		
		while(!pQueue.isEmpty() ) {
			int current = pQueue.poll().idx;
			
			if(!checked[current]) {
				checked[current] = true;
				
				for(Node node : adjList.get(current)) {
					if(!checked[node.idx] && dist[current] + node.w < dist[node.idx]) {
						dist[node.idx] = dist[current] + node.w;
						pQueue.offer(node);
					}
				}
			}
		}
		
		return dist[end];
	}
}

class Node implements Comparable<Node> {
	int w, idx;

	Node(int w, int idx) {
		this.w = w;
		this.idx = idx;
	}
	@Override
	public int compareTo(Node n) {
		return Integer.compare(this.w, n.w);
	}
}