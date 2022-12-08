package BOJ.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2304 {
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            return this.x - p.x;
        }
    }

    static int N;
    static Point[] pArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pArr = new Point[N];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pArr[i] = new Point(input[0], input[1]);
        }

        Arrays.sort(pArr);

        int total = 0;
        int maxPointIndex = 0;

        // 가장 높은 포인트 기준으로 왼쪽은 점점 커지는 구간만
        Point point = pArr[0];
        for(int i=1 ; i<N ; i++){
            Point p = pArr[i];

            if(point.y <= p.y){
                total += (p.x - point.x) * point.y;
                point = p;
                maxPointIndex = i;
            }
        }

        // 가장 높은 포인트 기준으로 오른쪽은 점점 작아지는 구간만
        point = pArr[N-1];
        for(int i=N-2 ; i>=maxPointIndex ; i--){
            Point p = pArr[i];

            if(point.y <= p.y){
                total += (point.x - p.x) * point.y;
                point = p;
            }
        }

        total += pArr[maxPointIndex].y;

        System.out.println(total);
    }
}
