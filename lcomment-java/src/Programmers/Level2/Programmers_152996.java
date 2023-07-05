package Programmers.Level2;

import java.util.Arrays;

/**
 * 시소 짝꿍
 */
public class Programmers_152996 {
    int count = 0;

    public long solution(int[] weights) {
        // 무게 오름차순 정렬
        Arrays.sort(weights);

        long saveCnt = 0;

        for(int i=0 ; i<weights.length-1 ; i++) {
            // 같은 무게일 경우 중복 쌍(1)만 빼주고 더함
            if(i != 0 && weights[i] == weights[i-1]) {
                saveCnt--;
                count += saveCnt;
                continue;
            }

            saveCnt = 0;
            for(int j=i+1 ; j<weights.length ; j++) {
                if(weights[i] == weights[j]
                   || weights[i] * 2 == weights[j]
                   || weights[i] * 3 == weights[j] * 2
                   || weights[i] * 4 == weights[j] * 3) {
                    saveCnt++;
                }
            }
            count += saveCnt;
        }

        return count;
    }


/* 시간 복잡도 문제로 TC 3개 시간초과
    int count = 0;

    public long solution(int[] weights) {
        // 무게 오름차순 정렬
        Arrays.sort(weights);

        combination(weights, new int[2], 0, 0);

        return count;
    }

    // 조합 백트래킹 활용
    private void combination(int[] weights, int[] select, int idx, int cnt) {
        if (cnt == 2) {
            if (pairCondition(select)) {count++;}
            return;
        }

        for (int i = idx; i < weights.length; i++) {
            select[cnt] = weights[i];
            combination(weights, select, idx+1, cnt+1);
        }
    }

    private boolean pairCondition(int[] select) {
        // 같을 경우
        if (select[0] == select[1]) {return true;}
        // 3:2 , 2:1
        if (select[0] * 3 == select[1] * 2
            || select[0] * 4 == select[1] * 2) {return true;}
        // 4:3
        if (select[0] * 4 == select[1] * 3) {return true;}

        return false;
    }
*/
}
