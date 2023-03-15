package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_21735 {
    static int N, M, result = Integer.MIN_VALUE;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initNM(sToIntArray(br.readLine()));
        seq = new int[N+1];
        int[] snows = sToIntArray(br.readLine());
        for(int i=1 ; i<=N ; i++){
            seq[i] = snows[i-1];
        }

        backtracking(0, 0, 1);

        System.out.println(result);
    }

    private static void backtracking(int start, int cnt, int sum) {
        if(cnt == M || !in(start)) {
            result = Math.max(result, sum);
            return;
        }

        backtracking(start+1, cnt+1, sum+seq[start+1]);
        backtracking(start+2, cnt+1, sum/2 + seq[start+2]);
    }

    private static boolean in(int idx) {
        return idx < N;
    }

    private static void initNM(int[] input) {
        N = input[0];
        M = input[1];
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
