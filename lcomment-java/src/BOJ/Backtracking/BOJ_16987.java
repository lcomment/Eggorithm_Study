package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_16987 {
    static class Egg {
        int durability, weight;
        boolean flag; // 깨졌으면 true

        Egg(int[] input) {
            this.durability = input[0];
            this.weight = input[1];
            this.flag = false;
        }
    }
    static int N, result = -1;
    static ArrayList<Egg> eggs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());

        for(int i=0 ; i<N ; i++) {
            eggs.add(new Egg(sToIntArray(br.readLine())));
        }

        backTracking(0, 0);
        System.out.println(result);
    }

    private static void backTracking(int idx, int cnt) {
        // 맨 오른쪽 계란이면 개수 세고 리턴
        if(idx == N) {
            result = Math.max(result, cnt);
            return;
        }

        // 가해자 계란이 이미 깨져있으면 재귀
        if(eggs.get(idx).durability <= 0 || cnt == N-1) {
            backTracking(idx + 1, cnt);
            return;
        }

        int save = cnt;
        for(int i=0 ; i<N ; i++) {
            // 깨져있으면 넘김
            if(idx == i || eggs.get(i).durability <= 0) continue;

            hitEggToEgg(idx, i);

            eggs.get(idx).flag = eggs.get(idx).durability <= 0;
            cnt += checkBreak(idx);
            eggs.get(i).flag = eggs.get(i).durability <= 0;
            cnt += checkBreak(i);
            
            backTracking(idx + 1, cnt);
            rollback(idx, i);
            cnt = save;
        }
    }

    private static void hitEggToEgg(int e1, int e2) {
        eggs.get(e1).durability -= eggs.get(e2).weight;
        eggs.get(e2).durability -= eggs.get(e1).weight;
    }

    private static void rollback(int e1, int e2) {
        eggs.get(e1).durability += eggs.get(e2).weight;
        eggs.get(e2).durability += eggs.get(e1).weight;
        eggs.get(e1).flag = false;
        eggs.get(e2).flag = false;
    }

    private static int checkBreak(int idx) {
        return eggs.get(idx).flag ? 1 : 0;
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[]  sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
