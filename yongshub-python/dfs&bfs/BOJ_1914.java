import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger number = new BigInteger("2");
        number = number.pow(N).subtract(BigInteger.ONE);

        System.out.println(number);
        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(sb);
        }

    }

    public static void hanoi(int cnt, int from, int temp, int to) {
        if(cnt == 0) return;

        hanoi(cnt - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(cnt - 1, temp, from, to);
    }
}
