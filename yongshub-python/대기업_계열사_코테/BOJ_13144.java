import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13144 {
    static int maxValue = 0;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(BOJ_13144::getMaxValue)
                .toArray();

        System.out.println(getAllCase(n, arr));
    }

    public static boolean getMaxValue(int value) {
        maxValue = Math.max(maxValue, value);
        return true;
    }

    public static int getAllCase(int n, int[] arr) {
        int start = 0;
        int cnt = 0;
        visited = new boolean[maxValue + 1];

        while(start < n) {
            visited[arr[start]] = true;
            cnt++;

            boolean check = true;
            int end;
            for(end = start + 1; end < n; end++) {
                if (visited[arr[end]]) {
                    reInitialize(start, end);
                    start++;
                    check = false;
                    break;
                }
                visited[arr[end]] = true;
                cnt++;
            }
            if(check) {
                reInitialize(start, end - 1);
                start++;
            }
        }
        return cnt;
    }

    public static void reInitialize(int start, int end) {
        while(start <= end) {
            visited[arr[end]] = false;
            end--;
        }
    }
}