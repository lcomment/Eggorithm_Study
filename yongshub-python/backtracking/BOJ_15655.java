import java.io.*;
import java.util.Arrays;

public class BOJ_15655 {
    static int N;
    static int M;
    static boolean[] visited = new boolean[10001];
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        // 1 <= M <= N <= 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = inputValues(br);
        N = NM[0];
        M = NM[1];
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted() // 정렬로 시작
                .toArray();

        backTracking(new int[M], 0);
        bw.flush();
        bw.close();
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void backTracking(int[] answer, int cnt) throws IOException {
        
        if(cnt == M) {
            for(int i = 0; i < cnt; i++) {
                bw.write(String.format("%d ", answer[i]));
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[arr[i]]) {
                continue;
            }
            if(cnt >= 1) {
                if(answer[cnt - 1] > arr[i]) continue;
            }
            visited[arr[i]] = true;
            answer[cnt] = arr[i];
            backTracking(answer, cnt + 1);
            visited[arr[i]] = false;
        }
    }
}
