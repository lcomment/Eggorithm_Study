package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 의문점: Max 값으로 처리할 때의 엣지 케이스를 모르겠음
 */
public class BOJ_2879 {
    /**
     * cur: 초기 인덴트 저장
     *
     */
    static class Line {
        int cur, move;
        boolean tabFlag;

        Line(int cur, int dest) {
            this.cur = cur;
            this.move = Math.abs(cur - dest);

            // 인덴트를 늘려야 하면 true, 줄여야 하면 false
            this.tabFlag = dest >= cur;
        }
    }
    static int N, result = 0;
    static int[] current, destination;
    static Line[] codes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        codes = new Line[N];

        current = sToIntArray(br.readLine());
        destination = sToIntArray(br.readLine());

        // 하나 밖에 없는 경우
        if(N < 2) {
            System.out.println(destination[0] - current[0]);
            return;
        }

        // Line 클래스에 맞게 입력값 파싱
        for(int idx=0 ; idx<N ; idx++) {
            codes[idx] = toLine(idx);
        }

        for(int i=1 ; i<N ; i++) {
            // 이전 코드와 현재 코드의 실행이 다른 경우
            if(codes[i-1].tabFlag != codes[i].tabFlag) {
                result += codes[i-1].move;
            }
            // 실행은 같은데 이전 코드가 더 많이 또는 똑같이 행해야 하는경우
            else if(codes[i-1].move >= codes[i].move) {
                result += codes[i-1].move - codes[i].move;
            }
        }

        result += codes[N-1].move;
        System.out.println(result);
    }

    private static Line toLine(int idx) {
        return new Line(current[idx], destination[idx]);
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
