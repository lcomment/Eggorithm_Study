import java.util.*;

import java.util.Arrays;
class pro_PE {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] add = new int[n+1];
        int answer = 0;
        for(int i=0; i<reserve.length; i++){
            add[reserve[i]] = 1;
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        answer += (n - lost.length);

        for(int i=0; i<lost.length; i++){
            if(add[lost[i]] == 1){
                add[lost[i]]= 2;
                answer++;
            }
        }

        for(int i=0; i<lost.length; i++){
            if(add[lost[i]] == 2)   continue;
            if(add[lost[i] -1] == 1){
                add[lost[i] - 1] = 0;
                answer++;
            }
            else if(lost[i] + 1 <= n && add[lost[i] + 1] == 1) {
                add[lost[i] + 1] = 0;
                answer++;
            }
        }
        return answer;
    }
}