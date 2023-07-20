package BOJ.Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16953 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int A = input[0];
        int B = input[1];
        dfs(A, B, 0);

        System.out.println(min != Integer.MAX_VALUE ? min + 1 : -1);
    }

    private static void dfs(int A, int B, int cnt) {
        if (A >= B) {
            if (A == B) {min = Math.min(min, cnt);}
            return;
        }

        if (B % 2 == 0) {
            dfs(A, B / 2, cnt + 1);
        }
        String s = String.valueOf(B);
        if (s.charAt(s.length() - 1) == '1' && s.length() >= 2) {
            dfs(A, Integer.parseInt(s.substring(0, s.length() - 1)), cnt + 1);
        }
    }
}
