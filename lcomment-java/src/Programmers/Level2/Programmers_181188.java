package Programmers.Level2;

import java.util.Arrays;

/*
 * 요격 시스템
 */
public class Programmers_181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);

        int right = targets[0][1];
        int answer = 1;

        for(int[] target : targets) {
            if(target[0] >= right) {
                answer++;
                right = target[1];
            }
        }

        return answer;
    }
}
