import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11660 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = inputValues(br);
        int n = inputs[0], m = inputs[1];
        arr = new int[n + 1][n + 1];

        initialize(br, n); // 누적 합 배열 초기화
        inputLocation(br, m); // 좌표 값 입력받기
        System.out.print(sb);
    }

    public static int[] inputValues(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static  void initialize(BufferedReader br, int n) throws IOException {
        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void inputLocation(BufferedReader br, int m) throws IOException {
        int[] inputs;

        for(int i = 0; i < m; i++) {
            inputs = inputValues(br);
            int x1 = inputs[0], y1 = inputs[1], x2 = inputs[2], y2 = inputs[3];
            getSumValue(x1, y1, x2, y2);
        }
    }

    public static void getSumValue(int x1, int y1, int x2, int y2) {
        int total = 0;
        for(int i = x1; i <= x2; i++) {
            total = total + (arr[i][y2] - arr[i][y1 - 1]);
        }
        sb.append(total).append("\n");
    }
}