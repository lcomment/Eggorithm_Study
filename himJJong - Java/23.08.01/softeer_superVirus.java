import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class softeer_superVirus {

    static final long MOD = 1000000007;
    static long K, P, N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        K = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        N = Long.parseLong(input[2]) * 10;

        System.out.println((sol(N) * K) % MOD);
    }

    static long sol(long n) {
        if (n == 1) {
            return P;
        }
        long ret = sol(n / 2);
        ret = (ret * ret) % MOD;
        if (n % 2 == 1) {
            ret = (ret * P) % MOD;
        }
        return ret % MOD;
    }
}
