package BOJ.Bipartite_Matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_11376 {
    static int n, m;
    static int[] matched;
    static ArrayList<Integer>[] edges;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = sToIntArray(br.readLine());
        n = input[0];
        m = input[1];

        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            input = sToIntArray(br.readLine());

            int taskKind = input[0];
            edges[i] = new ArrayList<>(taskKind);

            for(int j=1 ; j<=taskKind ; j++) {
                edges[i].add(input[j]);
            }
        }

        matched = new int[m+1];
        Arrays.fill(matched, -1);
        int cnt = 0;

        v = new boolean[m+1];
        for (int i = 1; i <= n; i++) {
            if (matching(i)) {
                cnt++;
                v = new boolean[m+1];
            }
        }

        v = new boolean[m+1];
        for (int i = 1; i <= n; i++) {
            if (matching(i)) {
                cnt++;
                v = new boolean[m+1];
            }
        }

        System.out.println(cnt);
    }

    private static boolean matching(int cur) {

        for (int next : edges[cur]) {
            if (v[next]) continue;
            v[next] = true;
            if (matched[next] == -1 || matching(matched[next])) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}