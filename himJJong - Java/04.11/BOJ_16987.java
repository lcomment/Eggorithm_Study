import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_16987 {

    static int N;
    static int[] dura;
    static int[] weight;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dura = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dura[i] = Integer.parseInt(st.nextToken()); // 계란의 내구도
            weight[i] = Integer.parseInt(st.nextToken()); // 계란의 무게
        }

        backTracking(0,0);  // index, 깨진 계란 카운트
        System.out.println(max);

    }

    private static void backTracking(int index, int breakEgg) {
        if(index == N){                         // 마지막 까지 도덜했을 때 꺠진 계란의 최댓값 갱신
            max = Math.max(breakEgg,max);
            return;
        }
        if(dura[index] <=0 || breakEgg == N-1){ // 해당 계란이 깨졌거나, 한개 남기고 다깨졌을 경우 -> 다음 계란 집어들기
            backTracking(index+1,breakEgg);
            return;
        }

        int memoryBreakEgg = breakEgg;          // 당시 꺠진 계란의 값을 되돌리기 위함

        for(int i=0; i<N; i++){
            if(i == index) continue;            // 본인 계란과 같은 것 비교시
            if(dura[i] <= 0) continue;          // 비교할 계란이 이미 깨져있는 경우

            crash(i,index);

            if(dura[i] <= 0) breakEgg++;
            if(dura[index] <= 0) breakEgg++;

            backTracking(index+1,breakEgg); // 비교 한 두 계란의 충돌하고서 어떤 결과일지 backTracking으로 확인
            recoverValue(i,index);                // 해당 비교가 끝나면 다시 되돌리고
            breakEgg = memoryBreakEgg;            // 깨진 계란값 전으로 업데이트
        }
    }

    private static void recoverValue(int i, int index) {
        dura[i] += weight[index];
        dura[index] += weight[i];
    }

    private static void crash(int i, int index) {
        dura[i] -= weight[index];
        dura[index] -= weight[i];
    }
}