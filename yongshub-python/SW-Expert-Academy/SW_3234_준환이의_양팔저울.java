import java.io.*;
import java.util.*;

public class Solution {

	public static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());;
			int[] weight = new int[N];
			boolean[] v = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			dfs(N, 0, 0, 0, weight, v);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	public static void dfs(int N, int cnt, int right, int left, int[] weight, boolean[] v) {
		if (cnt == N) {
			if (right <= left) {
				ans++;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				dfs(N, cnt + 1, right, left+weight[i], weight, v);
                if (left >= right + weight[i])
                	dfs(N, cnt + 1, right + weight[i], left, weight, v);
				v[i] = false;
			}
		}
	}
}