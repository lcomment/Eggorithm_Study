package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1713 {
	static int N, C;
	static int[] seq, student;
	static List<Integer> frames;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = stoi(br.readLine());
		C = stoi(br.readLine());
		seq = sToIntArray(br.readLine());
		student = new int[101];
		frames = new LinkedList<>();
		int index = 0;

		for (int s : seq) {
			// 이미 있는 학생의 경우
			if (findBySequence(s)) {
				student[s]++;
				continue;
			}

			// 사진틀 자리가 있는 경우
			if (index < N) {
				frames.add(s);
				student[s]++;
				index++;
				continue;
			}

			// 자리가 없는 경우
			int deleteFrame = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < frames.size(); i++) {
				int frame = frames.get(i);

				if (student[frame] < min) {
					min = student[frame];
					deleteFrame = i;
				}
			}

			student[frames.get(deleteFrame)] = 0;
			frames.remove(deleteFrame);
			frames.add(s);
			student[s]++;
		}

		Collections.sort(frames);
		for (int f : frames)
			System.out.print(f + " ");
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static boolean findBySequence(int seq) {
		for (int i = 0; i < frames.size(); i++) {
			int f = frames.get(i);
			if (f == seq)
				return true;
		}
		return false;
	}
}
