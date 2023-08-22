package dfs_bfs;

// BOJ 2668 숫자 고르기

/*
 * 주어진 예시는
 * 2 -> 1 <-3
 * 5 <-> 5 <- 4 <- 6 <- 7
 * 이 중에서 사이클이 발생하는 숫자는
 * 1 -> 3 -> 1
 * 3 -> 1 -> 3
 * 5 <-> 5
 * 이렇게 1, 3, 5가 된다.
 * 
 * start -> arr[start] -> arr[arr[start]] -> ... 이런 식으로 비교한다.
 * DFS로 나온 숫자가 사이클을 이루면( start == arr[...[start]...] ) , 시작(start) 숫자를 리스트에 담아준다.
 * 
 * 
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2668_숫자고르기 {
	
	static int N;
	static int[] arr;
	static ArrayList<Integer> list;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];				//	숫자는 1부터 시작하므로 N+1로 초기화 
		list = new ArrayList<>();
		isVisited = new boolean[N+1];	//	숫자는 1부터 시작하므로 N+1로 초기화 
		
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			isVisited[i] = true;
			DFS(i, i);
			isVisited[i] = false;
		}
		
		Collections.sort(list);	// 오름차순 정렬 
		
		bw.write(list.size() + "\n");
		
		for (int n : list) {
			bw.write(n + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	// start : 처음 시작한 인덱스로 arr에 넣어 그 다음 값을 찾는다, target은 마지막 숫자와 비교하기 위한 시작 숫자 
	private static void DFS(int start, int target) {
		if (!isVisited[arr[start]]) {
			isVisited[arr[start]] = true;
			DFS(arr[start], target);
			isVisited[arr[start]] = false;
		}
		
		if (arr[start] == target) {
			list.add(target);
		}
	}
}
