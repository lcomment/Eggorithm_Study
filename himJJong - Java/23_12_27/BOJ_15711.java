import java.beans.BeanInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ_15711 {
    public static boolean[] isPrime = new boolean[2_000_001];
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        eratosthenes();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long sum = A + B;

            if (sum < 4) {
                sb.append("NO").append("\n");
            } else if (sum % 2 == 0) { //골드바흐 추측
                sb.append("YES").append("\n");
            } else {
                if (check(sum - 2)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean check(long x) {
        if (x <= 2_000_000) return !isPrime[(int) x];

        for (int i = 0; i < list.size(); i++) {
            if (x % list.get(i) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void eratosthenes() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i <= 2_000_000; i++) {
            if (!isPrime[i]) {
                list.add(i);
                for (int j = i * 2; j <= 2_000_000; j += i)
                    isPrime[j] = true;
            }
        }
    }
}