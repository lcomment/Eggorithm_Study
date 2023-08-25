package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1106 {
	static int C, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = sToIntArray(br.readLine());
		C = input[0];
		N = input[1];

		int[] dp = new int[C + 101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			Marketing marketing = new Marketing(sToIntArray(br.readLine()));

			for (int j = marketing.effect; j < C + 101; j++) {
				if(dp[j - marketing.effect] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j - marketing.effect] + marketing.cost);
				}
			}
		}

		System.out.println(Arrays.stream(dp).skip(C).min().getAsInt());
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	static class Marketing {
		int cost, effect;

		Marketing(int[] input) {
			this.cost = input[0];
			this.effect = input[1];
		}
	}
}
