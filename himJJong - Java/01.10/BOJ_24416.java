import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416 {
    static int cnt = 0;
    static int dpCnt = 0;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n];
        fib(n);
        fibonacci(n);
        System.out.println(cnt);
        System.out.println(dpCnt);
    }

    public static int fib(int n) {

        if(n == 1 || n == 2){
            cnt++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n) {
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i < n; i++) {
            dpCnt++;
            memo[i] = memo[i-2] + memo[i-1];
        }
        return memo[n-1];
    }
}