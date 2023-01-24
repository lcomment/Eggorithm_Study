import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum1209 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr;
        StringTokenizer st;
        int T;

        for(int test_case = 1; test_case <= 10; test_case++) {
            arr = new int[100][100];
            T = Integer.parseInt(br.readLine());
            int maxValue = 0;

            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            maxValue = Math.max(maxValue, checkRows(arr));
            maxValue = Math.max(maxValue, checkColumns(arr));
            maxValue = Math.max(maxValue, checkCross(arr));

            System.out.println("#" + T + " " + maxValue);
        }
    }

    public static int checkRows(int[][] arr) {
        int maxValue = 0;
        for(int i = 0; i < 100; i++) {
            int temp = 0;
            for(int j = 0; j < 100; j++) {
                temp += arr[j][i];
            }
            maxValue = Math.max(maxValue, temp);
        }
        return maxValue;
    }

    public static int checkColumns(int[][] arr) {
        int maxValue = 0;
        for(int i = 0; i < 100; i++) {
            int temp = 0;
            for(int j = 0; j < 100; j++) {
                temp += arr[i][j];
            }
            maxValue = Math.max(maxValue, temp);
        }
        return maxValue;
    }

    public static int checkCross(int[][] arr) {
        int maxValue = 0;
        int temp = 0;
        for(int i = 0; i < 100; i ++) {
            maxValue += arr[i][i];
        }

        for(int i = 0; i < 100; i++) {
            temp += arr[i][99 - i];
        }

        return Math.max(maxValue, temp);
    }
}
