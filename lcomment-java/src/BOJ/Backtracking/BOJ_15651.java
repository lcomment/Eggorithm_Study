package BOJ.Backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_15651 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        init(br.readLine());
        backTracking(new int[M], 0);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void init(String s) {
         int[] input = sToIntArray(s);
         N = input[0];
         M = input[1];
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void backTracking(int[] save, int count) throws IOException {
        if(count == M) {
            bw.write(toString(save));
            return;
        }

        for(int i=1 ; i<=N ; i++) {
            save[count] = i;
            backTracking(save, count + 1);
        }
    }

    private static String toString(int[] save) {
        StringBuilder sb = new StringBuilder();
        for(int n : save) {
            sb.append(n).append(" ");
        }
        return sb.toString();
    }
}
