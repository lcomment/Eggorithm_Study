import java.io.*;
import java.util.*;

public class BOJ_16987 {
    static int depth, answer;
    static int[][] data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        depth = stoi(st.nextToken());
        data = new int[depth][2];
        answer = 0;

        for (int i = 0; i < depth; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            data[i][0] = a;     // 내구도
            data[i][1] = b;     // 무게
        }
        backTracking(0, 0);
        System.out.println(answer);
    }

    static void backTracking(int idx, int cnt) {        //idx => 현재 위치 , cnt => 몇번 깨졌는지
        if(idx== depth) return;                          // 깊이 만큼 간다면 return 하고 전 것 다시 끝까지 확인

        for (int i = 0; i < depth; i++) {               // 계란 전체 확인
            if(i == idx || data[i][0]<=0) continue;     // i번째 인덱스가 자기 자신이거나 || 고른 계란이 깨져있다면 continue

            if(data[idx][0]<=0) {                       // 현재 나의 계란이 깨져있다면
                backTracking(idx+1, cnt);          // 다음 계란을 선택하기 위함, 여기서 cnt 인 이유는 이미 깨진것을 앞에서 계산함
                return;
            }
            hitMatch(idx,i);

            int move = 0;
            if (data[idx][0] <= 0)
                move++;
            if (data[i][0] <= 0)
                move++;

            answer = Math.max(answer, cnt+move);

            backTracking(idx + 1, cnt + move);
            recoverMatch(idx,i);

        }
    }

    private static void recoverMatch(int idx, int i) {
        data[idx][0] += data[i][1];
        data[i][0] += data[idx][1];
    }

    private static void hitMatch(int idx, int i) {
        data[idx][0] -= data[i][1];
        data[i][0] -= data[idx][1];
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}