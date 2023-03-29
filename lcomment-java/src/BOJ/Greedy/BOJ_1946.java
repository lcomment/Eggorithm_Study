package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BOJ_1946 {
    static class Associate {
        int post, interview;

        Associate(int[] input) {
            this.post = input[0];
            this.interview = input[1];
        }
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = stoi(br.readLine());

        while(T-- > 0) {
            int N = stoi(br.readLine());

            List<Associate> list = new ArrayList<>();

            for(int i=0 ; i<N ; i++) {
                list.add(new Associate(sToIntArray(br.readLine())));
            }

            // 서류 점수로 정렬
            list.sort(Comparator.comparingInt(o -> o.post));

            int count = 1;
            int bestGrade = list.get(0).interview;

            for(int i=1 ; i<N ; i++) {
                int cur = list.get(i).interview;

                // 인터뷰 성적이 높아야만 카운트
                if(bestGrade > cur) {
                    count++;
                    bestGrade = cur;
                }
            } // for_i

            System.out.println(count);
        }

    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}