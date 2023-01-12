package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20922 {
    static int N, K;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputToNK(br.readLine());

        seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int start = 0, end = 0, len = 0;
        int[] save = new int[100_001];

        while(end < N) {
            while(end < N && save[seq[end]] + 1 <= K) {
                save[seq[end++]]++;
            }
            len = Math.max(len, end-start);
            save[seq[start++]]--;
        }
        System.out.println(len);
    }

    private static void inputToNK(String s) {
        int[] NK = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NK[0];
        K = NK[1];
    }
}
