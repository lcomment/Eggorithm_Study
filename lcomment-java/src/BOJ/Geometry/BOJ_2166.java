package BOJ.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sToI(br.readLine()) ;
        long[][] points = new long[N+1][2];

        for(int i=0 ; i<N ; i++) {
            points[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
        }

        points[N][0] = points[0][0];
        points[N][1] = points[0][1];

        long a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            a += points[i][0] * points[i + 1][1];
            b += points[i + 1][0] * points[i][1];
        }

        System.out.printf("%.1f%n", Math.abs(a - b) / 2.0);
    }
    static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
