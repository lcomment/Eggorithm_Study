package Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_13913 {
	static int N, K;
	static int[] times= new int[100_001];
	static int[] parents= new int[100_001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0];
		K = input[1];
		
		bfs();
		
//		ArrayList<Integer> root = new ArrayList<>();
		Stack<Integer> root = new Stack<>();
		root.push(K);
		
		while(K != N) {
			root.push(parents[K]);
			K = parents[K];
		}
		
		System.out.println(root.size() - 1);
		
		while(!root.isEmpty()) {
			System.out.print(root.pop() + " ");;
		}
		
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K)
				break;
			
			int[] move = {cur-1, cur+1, cur*2};
			for(int i=0 ; i<3 ; i++) {
				int next = move[i];
				
				if(next < 0 || next > 100_000) continue;
				
				if(times[next] == 0 || times[next] > times[cur] + 1) {
					q.offer(next);
					times[next] = times[cur] + 1;
					parents[next] = cur;
				}
			}
		}
		
	}
}
