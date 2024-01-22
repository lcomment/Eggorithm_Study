import java.util.*;
import java.io.*;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N + 1];
        int[] y = new int[N + 1];
        long sum_a = 0;
        long sum_b = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        for (int i = 0; i < N; i++) {
            sum_a += (long) x[i] * y[i + 1];
            sum_b += (long) x[i + 1] * y[i];
        }

        String area = String.format("%.1f", (Math.abs(sum_a - sum_b) / 2.0));
        System.out.println(area);
    }
}