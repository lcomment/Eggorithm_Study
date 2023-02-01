package BOJ.Implementation;

import java.io.*;
import java.util.Arrays;

public class BOJ_14503 {
    static class Robot {
        // d: 0-북, 1-동, 2-남, 3-서
        int r, c, d;

        Robot(int[] input) {
            this.r = input[0];
            this.c = input[1];
            this.d = input[2];
        }
    }
    static int R, C, result = 1;
    static int[][] map;

    /*
     * 북 : -> r-1, c
     * 동 : -> r, c+1
     * 남 : -> r+1, c
     * 서 : -> r, c-1
     */
    static int[][] nextLeft = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    /*
     * 북(0) -> r+1, c
     * 동(1) -> r, c-1
     * 남(2) -> r-1, c
     * 서(3) -> r, c+1
     */
    static int[][] nextBack = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init(br.readLine());
        map = new int[R][C];
        Robot robot = new Robot(sToIntArray(br.readLine()));

        for(int i=0 ; i<R ; i++) {
            map[i] = sToIntArray(br.readLine());
        }

        clean(robot.r, robot.c, robot.d);
        System.out.println(result);
    }

    private static void init(String s) {
         int[] input = sToIntArray(s);
         R = input[0];
         C = input[1];
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void clean(int r, int c, int d) {
        cleanCurrentPosition(r, c);

        for(int i=0 ; i<4 ; i++) {
            d = turnLeft(d);
            int nr = r + nextLeft[d][0];
            int nc = c + nextLeft[d][1];

            if(in(nr, nc) && canClean(nr, nc)) {
                result++;
                clean(nr, nc, d);
                return;
            }
        }

        int br = r + nextBack[d][0];
        int bc = c + nextBack[d][1];

        if (in(br, bc) && canMoveBack(br, bc)) {
            clean(br, bc, d);
        }
    }

    private static boolean canClean(int r, int c) {
        return  map[r][c] == 0;
    }

    private static boolean canMoveBack(int r, int c) {
        return  map[r][c] != 1;
    }

    private static boolean in(int r, int c) {
        return 0<=r && r<R && 0<=c && c<C;
    }

    private static void cleanCurrentPosition(int r, int c) {
        // 청소는 -1로 표시
        map[r][c] = -1;
    }

    private static int turnLeft(int d) {
        return d-1 >= 0 ? d-1:3;
    }
}
