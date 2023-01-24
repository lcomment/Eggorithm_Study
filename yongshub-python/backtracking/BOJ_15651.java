import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_15651 {
    static int N, M;
    static int[] visited;
    static StringBuilder answer = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int[] NM = inputValues();
        StringBuilder sb = new StringBuilder();
        N = NM[0];
        M = NM[1];

        visited = new int[N + 1];
        backTracking(sb, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static int[] inputValues() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void backTracking(StringBuilder sb, int cnt) {
        if(cnt == M) {
            answer.append(sb).append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i] < M) {
                visited[i]++;
                sb.append(String.format("%d ", i));
                backTracking(sb, cnt + 1);
                sb.delete(sb.length() - 2, sb.length());
                visited[i]--;
            }
        }
    }
}
