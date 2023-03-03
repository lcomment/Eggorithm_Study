package BOJ.Disjoint_Set;

import java.io.*;
import java.util.Arrays;

public class BOJ_1717 {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        init(br.readLine());

        for(int i=0 ; i<M ; i++) {
            int[] input = sToIntArray(br.readLine());

            // 합집합(union) 명령
            if(input[0] == 0) {
                union(input[1], input[2]);
            }
            // 합집합인지(부모가 같은지) 체크
            else if(input[0] == 1) {
                sb.append(check(input[1], input[2]) ? "YES":"NO");
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parents[y] = x;
        } else if(x > y) {
            parents[x] = y;
        }
    }

    private static int find(int x) {
        if(x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    private static void init(String s) {
        int[] input = sToIntArray(s);

        N = input[0];
        M = input[1];
        parents = new int[N+1];

        for(int i=0 ; i<=N ; i++) {
            parents[i] = i;
        }
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
