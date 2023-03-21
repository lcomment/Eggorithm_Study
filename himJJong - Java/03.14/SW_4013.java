import java.io.*;
import java.util.*;

public class SW_4013 {
    static int K;
    static int res; // 회전이 끝난 후 획득 점수
    static int[][] magnet;
    static int[] dir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            res = 0;
            K = Integer.parseInt(br.readLine());

            magnet = new int[5][8]; // 1~4번까지의 n극, s극 저장
            dir = new int[5];       // 1~4번의 회전 방향 (0: 회전 x, -1: 반시계, 1: 시계)
            for (int i = 1; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 명령어 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()); // num 자석을 d방향으로 회전
                int d = Integer.parseInt(st.nextToken());
                dir[num] = d;
                setDirLeft(num - 1); // num 기준 좌측로 회전방향 세팅
                setDirRight(num + 1); // num 기준 우측으로 회전방향 세팅
                moveMagnet(); // 각 톱니바퀴들을 회전방향에 맞게 회전
            }

            for (int i = 1; i < 5; i++) {
                if (magnet[i][0] == 1)
                    res += Math.pow(2, i - 1);
            }
            System.out.println("#" + t + " " + res);
        }
    }
    private static void setDirLeft(int num) {
        if (num == 0)
            return;
        // num의 2번과 num+1의 6번 비교
        if (dir[num + 1] == 0)
            dir[num] = 0;
        else if (magnet[num + 1][6] == magnet[num][2])
            dir[num] = 0;
        else
            dir[num] = dir[num + 1] == -1 ? 1 : -1; // 반대 방향 회전

        setDirLeft(num - 1);
    }

    private static void setDirRight(int num) {
        if (num > 4)
            return;
        // num의 6번과 num-1의 2번 비교
        if (dir[num - 1] == 0) // 이전 자석이 회전 X 이면 자신도 회전 x
            dir[num] = 0;
        else if (magnet[num - 1][2] == magnet[num][6]) { // 자성이 같을 경우 회전 X
            dir[num] = 0;
        } else {
            dir[num] = dir[num - 1] == -1 ? 1 : -1; // 반대 방향 회전
        }
        setDirRight(num + 1);

    }

    private static void moveMagnet() {
        for (int i = 1; i < 5; i++) {
            int d = dir[i];
            if (d == 0) // 회전 X이면
                continue;
            else if (d == 1) {
                Circle(i, magnet);// i번째 톱니바퀴 시계방향 회전
            } else if (d == -1) {
                ReverseCircle(i, magnet);// i번째 톱니바퀴 반시계방향 회전
            }
        }

    }

    private static int[][] ReverseCircle(int num, int[][] magnet) { // 반시계
        int data[] = copy(magnet[num]);
        for (int i = 0; i < 8; i++) {
            magnet[num][i] = data[(i + 1 + 8) % 8];
        }
        return magnet;

    }

    private static int[][] Circle(int num, int[][] magnet) { // 시계
        int data[] = copy(magnet[num]);
        for (int i = 0; i < 8; i++) {
            magnet[num][i] = data[(i - 1 + 8) % 8];
        }
        return magnet;
    }

    private static int[] copy(int[] arr) { // 배열 복사
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        return tmp;
    }
}