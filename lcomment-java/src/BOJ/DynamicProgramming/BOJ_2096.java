package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2096 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            map[i] = sToIntArray(br.readLine());
        }

        // dp 테이블 초기화
        dpMax[0][0] = dpMin[0][0] = map[0][0];
        dpMax[0][1] = dpMin[0][1] = map[0][1];
        dpMax[0][2] = dpMin[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0] + map[i][0], dpMax[i - 1][1] + map[i][0]);
            dpMax[i][1] = Math.max(dpMax[i - 1][0] + map[i][1],
                                   Math.max(dpMax[i - 1][1] + map[i][1],
                                            dpMax[i - 1][2] + map[i][1]));
            dpMax[i][2] = Math.max(dpMax[i - 1][1] + map[i][2], dpMax[i - 1][2] + map[i][2]);
            dpMin[i][0] = Math.min(dpMin[i - 1][0] + map[i][0], dpMin[i - 1][1] + map[i][0]);
            dpMin[i][1] = Math.min(dpMin[i - 1][0] + map[i][1],
                                   Math.min(dpMin[i - 1][1] + map[i][1],
                                            dpMin[i - 1][2] + map[i][1]));
            dpMin[i][2] = Math.min(dpMin[i - 1][1] + map[i][2], dpMin[i - 1][2] + map[i][2]);
        }

        System.out.println(max(dpMax[N - 1][0], dpMax[N - 1][1], dpMax[N - 1][2])
                           + " "
                           + min(dpMin[N - 1][0], dpMin[N - 1][1], dpMin[N - 1][2]));
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
