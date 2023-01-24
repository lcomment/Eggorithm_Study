package BOJ.Dfs_Bfs;

import java.io.*;
import java.util.Arrays;

public class BOJ_9466 {
    static int T, N, cnt;
    static int[] seq;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = sToI(br.readLine());

        while(T-- > 0) {
            N = sToI(br.readLine());
            seq = sToIntArray(br.readLine());
            visited = new boolean[N];
            finished = new boolean[N];
            cnt = 0;

            for(int i=0 ; i<N ; i++) {
                // 1번부터
                dfs(i);
            }
            sb.append(N - cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        int[] input = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for(int i=0; i<input.length ; i++) {
            input[i]--;
        }
        return input;
    }

    private static void dfs(int now) {
        if(visited[now]) {
            return;
        }

        visited[now] = true;
        int next = seq[now];

        if(!visited[next]) {
            dfs(next);
        } else {
            if(!finished[next]) {
                cnt++;

                for (int i = next; i != now; i = seq[i]) cnt++;
            }
        }
        finished[now] = true;
    }
}
