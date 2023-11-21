import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Swea_hamburgerDiot {
    static int burger;
    static int limit;
    static long max = Long.MIN_VALUE;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            burger = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            data = new int[burger][2];
            for (int i = 0; i < burger; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                data[i][0] = left;
                data[i][1] = right;
            }

            max = Long.MIN_VALUE; // 각 테스트케이스마다 max 초기화
            btk(0, 0, 0);

            System.out.println("#" + test + " " + max);
        }
    }

    static void btk(int at, int calory, int happy) {
        if (calory > limit) {
            return;
        }

        max = Math.max(max, happy);

        for (int i = at; i < burger; i++) {
            calory += data[i][1];
            happy += data[i][0];
            btk(i + 1, calory, happy); // 재귀 호출 시에는 at + 1이 아니라 i + 1을 사용해야 합니다.
            calory -= data[i][1];
            happy -= data[i][0];
        }
    }
}
