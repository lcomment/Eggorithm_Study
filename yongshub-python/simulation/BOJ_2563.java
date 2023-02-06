import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2563 {
    static int[][] white = new int[100][100];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int[] NM = inputValues(br);
            fillArrayByIndex(100 - NM[1], NM[0]);
        }

        System.out.println(getWidthBlackSector());
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void fillArrayByIndex(int x, int y) {
        for(int i = x - 10; i < x; i++) {
            Arrays.fill(white[i], y, y + 10, 1);
        }
    }

    public static int getWidthBlackSector() {
        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if (white[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}
