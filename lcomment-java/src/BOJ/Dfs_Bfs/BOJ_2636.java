package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2636 {
	static int R, C;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = sToIntArray(br.readLine());
		R = input[0];
		C = input[1];
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = sToIntArray(br.readLine());
		}

		int time = 0;
		int lastCount = calculateCheese();
		while (true) {
			bfs();
			meltingCheese();

			time++;
			int cnt = calculateCheese();
			if(cnt == 0) {
				System.out.println(time);
				System.out.println(lastCount);
				break;
			} else {
				lastCount = cnt;
			}
		}
	}

	private static void bfs() {
		boolean[][] visited = new boolean[R][C];
		q.offer(new Node(0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];

				if (!in(nr, nc) || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				if (map[nr][nc] == 0) {
					q.offer(new Node(nr, nc));
				} else if (map[nr][nc] == 1) {
					map[nr][nc] = 2;
				}
			} // for
		} // while_q
	}

	private static void meltingCheese() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 2) {
					map[r][c] = 0;
				}
			}
		}
	}

	private static int calculateCheese() {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					count++;
				}
			}
		}
		return count;
	}

	private static boolean in(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

	private static int[] sToIntArray(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
