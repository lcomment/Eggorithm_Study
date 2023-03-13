package BOJ.Disjoint_Set;

import java.io.*;
import java.util.*;


/*
 * 입력을 stream으로 int 배열로 계속 바꿔쓰다가 뇌절됨
 * TC 여러개 조지는 문제는 System.out이 더 효율적일거 같음
 */

public class BOJ_7511 {
    static int N, K, M;
    static int[] parents;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = stoi(br.readLine());

        for(int t = 1; t <= tc; t++) {
            N = stoi(br.readLine());
            K = stoi(br.readLine());
            parents = new int[N];

            for(int i=0 ; i<parents.length ; i++) {
                parents[i] = i;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                union(a, b);
            }

            M = stoi(br.readLine());
            sb.append(String.format("Scenario %d:%n", t));
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());

                if(find(u) == find(v))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x) {
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(parents[x] < parents[y]) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}