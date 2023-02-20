import java.util.*;
import java.io.*;
import java.util.*;

public class BOJ_14891 {
    static int[][] spinData;
    static int[][] data;
    static int spin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;

        data = new int[4][8];

        for (int i = 0; i < 4; i++) {
            data[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        spin = Integer.parseInt(br.readLine());
        spinData = new int[spin][2];

        for (int i = 0; i < spin; i++) {
            spinData[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            move(spinData[i][0]-1, spinData[i][1]);
        }

        for(int i=0; i<4; i++) {
            total += Math.pow(2, i)*data[i][0];
        }

        System.out.println(total);
    }
    private static void move(int wheelNumber, int direction) {
        leftSpin(wheelNumber-1, -direction);
        rightSpin(wheelNumber+1, -direction);
        changeWheel(wheelNumber, direction);
    }

    private static void leftSpin(int index, int dir) {
        if(index < 0) return;
        if(data[index][2]==data[index+1][6]) return;
        leftSpin(index-1, -dir);
        changeWheel(index,dir);
    }

    private static void rightSpin(int index, int dir) {
        if(index > 3) return;
        if(data[index][6]==data[index-1][2]) return;
        rightSpin(index+1, -dir);
        changeWheel(index,dir);
    }
    private static void changeWheel(int index, int dir) {  // 움직인 톱니바퀴 배열 값 정정
        if(dir==1) {
            int tmp = data[index][7];
            for(int i=7; i>0; i--) {
                data[index][i] = data[index][i-1];
            }
            data[index][0] = tmp;
        }
        else {
            int tmp = data[index][0];
            for(int i=0; i<7; i++) {
                data[index][i] = data[index][i+1];
            }
            data[index][7] = tmp;
        }
    }
}