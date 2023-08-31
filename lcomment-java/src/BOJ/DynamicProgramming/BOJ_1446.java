package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1446 {
	static int N, D;
	static Map<Integer, List<Info>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = sToIntArray(br.readLine());
		N = input[0];
		D = input[1];

		int[] dp = new int[D + 1];

		for (int i = 0; i < N; i++) {
			input = sToIntArray(br.readLine());

			if (!map.containsKey(input[1])) {
				map.put(input[1], new ArrayList<>());
			}

			map.get(input[1]).add(new Info(input[0], input[2]));
		}

		for (int i = 1; i <= D; i++) {
			int length = dp[i - 1] + 1;

			if(map.containsKey(i)) {
				for(Info info : map.get(i)) {
					length = Math.min(length, dp[info.start] + info.length);
				}
			}
			dp[i] = length;
		}

		System.out.println(dp[D]);
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	static class Info {
		int start, length;

		Info(int start, int length) {
			this.start = start;
			this.length = length;
		}
	}
}
