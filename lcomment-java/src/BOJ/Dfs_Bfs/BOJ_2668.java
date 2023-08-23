package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2668 {
	static int N;
	static int[] seq;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		N = stoi(br.readLine());
		seq = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			seq[i] = stoi(br.readLine());
		}

		for(int i=1 ; i<=N ; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}

		Collections.sort(list);

		System.out.println(list.size());
		list.forEach(System.out::println);
	}

	private static void dfs(int start, int target) {
		if (!visited[seq[start]]) {
			visited[seq[start]] = true;
			dfs(seq[start], target);
			visited[seq[start]] = false;
		}

		if (seq[start] == target)
			list.add(seq[start]);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
