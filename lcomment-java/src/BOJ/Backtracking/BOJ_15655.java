package BOJ.Backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_15655 {
    static int N, M;
    static int[] seq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init(br.readLine());
        seq = sToIntArray(br.readLine());
        Arrays.sort(seq);

        backTracking(new int[M],new boolean[N],0,0);

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

    private static void backTracking(int[] save, boolean[] visited, int start, int count) throws IOException {
       if(count == M) {
            bw.write(toString(save) + "\n");
            return;
        }

        for(int i=start ; i<N ; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            save[count] = seq[i];
            backTracking(save, visited, i + 1, count + 1);
            visited[i] = false;
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
