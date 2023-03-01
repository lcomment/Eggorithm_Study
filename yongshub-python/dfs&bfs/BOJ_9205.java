import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class BOJ_9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<int[]> convenientStores;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    static int endX, endY;

    private static boolean getDistance(int startX, int startY) {
        if (Math.abs(startX - endX) + Math.abs(startY - endY) <= 1000) {
            return true;
        }

        for (int i = 0; i < convenientStores.size(); i++) {
            if(visited[i]) continue;
            if(Math.abs(startX - convenientStores.get(i)[0]) + Math.abs(startY - convenientStores.get(i)[1]) > 1000) continue;
            visited[i] = true;
            if(getDistance(convenientStores.get(i)[0], convenientStores.get(i)[1])) return true;
            visited[i] = true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int cnt = Integer.parseInt(br.readLine());
            convenientStores = new ArrayList<>();
            String[] start = br.readLine().split(" ");
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);

            for (int j = 0; j < cnt; j++) { // 편의점 좌표 구하기
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                convenientStores.add(arr);
            }

            visited = new boolean[cnt];
            start = br.readLine().split(" ");
            endX = Integer.parseInt(start[0]);
            endY = Integer.parseInt(start[1]);

            if(getDistance(startX, startY)) {
                sb.append("happy\n");
            } else {
              sb.append("sad\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}