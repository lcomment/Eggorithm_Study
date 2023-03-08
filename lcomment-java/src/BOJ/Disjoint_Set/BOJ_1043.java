package BOJ.Disjoint_Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, result = 0;
    static int[] parents;
    static boolean[] knownList;
    static List<int[]> parties;

    public static void main(String[] args) throws IOException {
        init();

        for(int p=0 ; p<M ; p++) {
            int[] input = sToIntArray(br.readLine());
            int total = input[0];

            int[] party = new int[total];
            party[0] = input[1];

            for (int n=2; n<=total; n++){
                party[n-1] = input[n];

                if (input[1] < party[n-1]) union(input[1], party[n-1]);
                else union(party[n-1], input[1]);
            }
            parties.add(party);
        }

        for (int[] tmp : parties){
            boolean flag = false;
            for (int item : tmp){
                if (!check(item)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result++;
        }
        System.out.println(result);
    }

    static public int find(int x){
        if (x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    static public void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) parents[y] = x;
    }

    static public boolean check(int x){
        x = find(x);
        for (int i=1 ; i<knownList.length ; i++) {
            if(knownList[i] && x == find(i)) {
                return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        int[] input = sToIntArray(br.readLine());

        N = input[0];
        M = input[1];

        parents = new int[N+1];
        parties = new ArrayList<>();
        knownList = new boolean[N+1];

        for(int p=1 ; p<=N ; p++) {
            parents[p] = p;
        }

        input = sToIntArray(br.readLine());

        // 진실을 아는 사람이 없으면 모드 파티에서 구라칠 수 있음
        if(input[0] == 0) {
            System.out.println(M);
            System.exit(0);
        }

        for(int i=1 ; i<=input[0] ; i++) {
            knownList[input[i]] = true;
        }
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
