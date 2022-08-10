package chapter2;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class TypeInference {
	static int N, K, minTime = Integer.MAX_VALUE;		//출발, 도착, 최소 시간 -> 최댓값으로 초기화
	static int[] times = new int[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());	//시작위치 
		K = Integer.parseInt(st.nextToken());	//도착위치 
		
		Arrays.fill(times,Integer.MAX_VALUE);
		Dijkstra();
		System.out.println(times[K]);
	}
	private static void Dijkstra() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(N,0));		            // 시작 
		times[N] = 0;		
		
		while(!pq.isEmpty()) {
			Node p = pq.poll();		
			
			int arr[] = {p.x-1, p.x+1, p.x*2};         
			for(int i=0; i<3 ; i++) {
				if(arr[i] < 0 || arr[i] > 100000 || p.time >= times[arr[i]]) continue;
				
				if(i < 2) {
					times[arr[i]] = p.time + 1;
					pq.offer(new Node(arr[i], p.time+1));
				}
				else {
					times[arr[i]] = p.time;
					pq.offer(new Node(arr[i], p.time));
				}
			}
    }
  }
	static class Node implements Comparable<Node>{
		int x;
		int time;
		
		Node(int x, int time){
			this.x = x;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
}
