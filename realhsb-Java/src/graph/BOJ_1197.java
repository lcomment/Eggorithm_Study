package graph;

// BOJ 1197 최소 스패닝 트리 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BOJ_1197 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 개수 
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		parent = new int[V+1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new Edge(s, e, w));
		}
		
		int answer = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s, now.e);
				answer += now.w;
			}
		}
		System.out.println(answer);
	}
	
	public static void union(int x, int y) {
		x = find(x);	// 부모 찾기 
		y = find(y);
		
		if(x < y) parent[y] = x;	// 부모를 합칠 때 일반적으로 더 작은 값 쪽으로 합침. 
		else parent[x] = y;
	}
	
	public static int find(int x) {
		if(parent[x] == x) 
			return x;
		else 
			return parent[x] = find(parent[x]);
	}
}

class Edge implements Comparable<Edge>{
	int s, e, w;	// 시작점, 끝점, 가중치 

	Edge(int s, int e, int w){
		this.s = s;
		this.e = e;
		this.w = w;
	}
	
	@Override
	public int compareTo(Edge o) {		// 오름차순 	
		return w - o.w;
	}
}

