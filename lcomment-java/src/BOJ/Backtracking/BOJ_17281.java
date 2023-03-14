package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_17281 {
    private static int N, result = Integer.MIN_VALUE;
    private static int[][] hitMap;
    private static int[] np, seq;

    private static int[] player;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        hitMap = new int[N][9];
        np = IntStream.range(0, 10).toArray();

        for(int i=0 ; i<N ; i++) {
            hitMap[i] = sToIntArray(br.readLine());
        }

        do {
            seq = np.clone();

            int start = seq[0];
            seq[0] = seq[1];
            seq[1] = seq[2];
            seq[2] = seq[3];
            seq[3] = start;

            result = Math.max(result, play());
        } while(nextPermutation());

        System.out.println(result);
    }

    private static int play() {
        int sum = 0, i = 0;

        for(int inning=0; inning<N ; inning++) {
            int out = 0;
            int[] bases = new int[4];

            while(out < 3) {
                if(hitMap[inning][seq[i]] == 0) {
                    out++;
                } else {
                    bases[0]++;
                    sum += run(bases, hitMap[inning][seq[i]]);
                }
                i = (i + 1) % 9;
            } // while_out
        }
        return sum;
    }

    private static int run(int[] bases, int flag) {
        int sum = 0;

        switch(flag) {
            case 1 -> {
                sum += bases[3];
                for(int i=2 ; i>=0 ; i--) bases[i + 1] = bases[i];

                bases[0] = 0;
            }
            case 2 -> {
                sum += bases[2] + bases[3];
                for(int i=1 ; i>=0 ; i--) bases[i + 2] = bases[i];

                bases[1] = 0;
                bases[0] = 0;
            }
            case 3 -> {
                sum += bases[1] + bases[2] + bases[3];

                bases[3] = bases[0];
                bases[2] = 0;
                bases[1] = 0;
                bases[0] = 0;
            }
            case 4 -> {
                sum += Arrays.stream(bases).sum();

                bases[3] = 0;
                bases[2] = 0;
                bases[1] = 0;
                bases[0] = 0;
            }
        }
        return sum;
    }

    private static boolean nextPermutation() {
        int i = 8;
        while(i>1 && np[i-1]>=np[i]) i--;
        // 다음 순열이 없는 경우 종료
        if(i == 1) return false;

        int j = 8;
        while(np[i-1]>=np[j]) j--;
        swap(i-1, j);

        j = 8;
        while(i<j) {
            swap(i++, j--);
        }
        return true;
    }

    private static void swap(int idx1, int idx2) {
        int save = np[idx1];
        np[idx1] = np[idx2];
        np[idx2] = save;
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
