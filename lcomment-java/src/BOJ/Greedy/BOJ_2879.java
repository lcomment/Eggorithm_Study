package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2879 {
    /**
     * cur: 초기 인덴트 저장
     *
     */
    static class Line {
        int cur, dest, move;
        boolean tabFlag, satisfied;

        Line(int cur, int dest) {
            this.cur = cur;
            this.dest = dest;
            this.move = Math.abs(cur - dest);

            // 처음부터 만족하는 인덴트일 수도 있음
            this.satisfied = this.cur == this.dest;
            // 인덴트를 늘려야 하면 true, 줄여야 하면 false
            this.tabFlag = dest >= cur;
        }

        void tab(int n) {
            this.satisfied = this.cur + n == dest;
        }

        void unTab(int n) {
            this.satisfied = this.cur - n == dest;
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

        // Line 클래스에 맞게 입력값 파싱
        for(int idx=0 ; idx<N ; idx++) {
            codes[idx] = toLine(idx);
        }

        // 인덴트를 추가할지 감소할지 저장
        boolean tabFlag = codes[0].tabFlag;
        int start = 0;
        int end = 0;
        int max = 0;

        while(start < N && end < N) {
            // end 인덱스의 코드가 인덴트를 만족하지 않으면서, 기존의 코드와 tabFlag 가 동일할 때
            if(!codes[end].satisfied && tabFlag == codes[end].tabFlag) {
                max = Math.max(max, codes[end].move);
                end++;
            } else if (!codes[end].satisfied && tabFlag != codes[end].tabFlag) {
                for(int idx=start ; idx<end; idx++) {
                    // 모두 만족하게 바꾸고, max만큼 result를 증가
                    codes[idx].satisfied = true;
                }
                result += max;
                tabFlag = codes[end].tabFlag;
                max = codes[end].move;

                start = end;
                end++;

            } else {
                if(start < end) {
                    for(int idx=start ; idx<end; idx++) {
                        // 모두 만족하게 바꾸고, max만큼 result를 증가
                        codes[idx].satisfied = true;
                    }
                    result += max;
                }
                end++;
                start = end;
                max = 0;
                tabFlag = codes[end].tabFlag;
            }
        } // while_start

        if(max != 0) {
            for(int idx=start ; idx<N; idx++) {
                // 모두 만족하게 바꾸고, max만큼 result를 증가
                codes[idx].satisfied = true;
            }
            result += max;
        }

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
