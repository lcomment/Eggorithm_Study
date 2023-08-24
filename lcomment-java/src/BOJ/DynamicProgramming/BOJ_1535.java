package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1535 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = stoi(br.readLine());
		int[] tire = sToIntArray(br.readLine());
		int[] good = sToIntArray(br.readLine());

		int[][] dp = new int[N + 1][100];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < 100; j++) {
				if (tire[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tire[i - 1]] + good[i - 1]);
				}
			}
		}

		System.out.println(dp[N][99]);
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
