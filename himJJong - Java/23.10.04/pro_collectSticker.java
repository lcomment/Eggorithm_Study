import java.util.*;

class pro_collectSticker {
    public int solution(int sticker[]) {
        int max = Integer.MIN_VALUE;
        int len = sticker.length;

        if (len == 1) return sticker[0];
        else if(len ==2) return Math.max(sticker[0], sticker[1]);

        int[] dp1 = new int[len];

        //첫번째 스티커를 떼는 방법
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < len-1;i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
            max = Math.max(max, dp1[i]);
        }

        Arrays.fill(dp1,0);
        dp1[1] = sticker[1];

        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
            max = Math.max(dp1[i],max);
        }

        return max;
    }
}
