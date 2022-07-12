package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2252 {
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] edgeCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = NM[0];
		int M = NM[1];
		
		adjList = new ArrayList<>();
		edgeCount = new int[N+1]; 
		
		for(int i=0 ; i<=N ; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i=0 ; i<M ; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			adjList.get(input[0]).add(input[1]);
			edgeCount[input[1]]++;
		}
		
		topologicalSort();
	}
	static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1 ; i<edgeCount.length ; i++) {
			if(edgeCount[i] == 0)
				queue.offer(i);
		} // for_i
		
		for(int i=0 ; i<adjList.size() ; i++) {
			if(queue.isEmpty())
				break;
			int zeroEdge = queue.poll();
			System.out.print(zeroEdge + " ");
			
			for(int link : adjList.get(zeroEdge)) {
				edgeCount[link]--;
				
				if(edgeCount[link] == 0)
					queue.offer(link);
			}
		} // for_i
	}
}
