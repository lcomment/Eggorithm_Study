package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_13335 {
	static int N, W, L;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = sToIntArray(br.readLine());
		N = input[0];
		W = input[1];
		L = input[2];
		seq = sToIntArray(br.readLine());

		Queue<Integer> trucks = new LinkedList<>();
		Queue<Integer> bridges = new LinkedList<>();

		int time = 0;
		int weight = 0;

		for (int i = 0; i < N; i++) {
			trucks.offer(seq[i]);
		}
		for (int i = 0; i < W; i++) {
			bridges.offer(0);
		}

		while (!bridges.isEmpty()) {
			weight -= bridges.poll();

			if (!trucks.isEmpty()) {
				if (trucks.peek() + weight <= L) {
					int truck = trucks.poll();
					weight += truck;
					bridges.offer(truck);
				} else {
					bridges.offer(0);
				}
			}
			time++;
		}

		System.out.println(time);
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
