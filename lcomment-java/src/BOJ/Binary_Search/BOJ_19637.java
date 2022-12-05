package BOJ.Binary_Search;

import java.io.*;
import java.util.Arrays;

public class BOJ_19637 {
    static class IF implements Comparable<IF> {
        String name;
        int point;

        IF(String name, int point){
            this.name = name;
            this.point = point;
        }
        @Override
        public int compareTo(IF o){
            return this.point - o.point;
        }
    }
    static int N, M;
    static IF[] makeIf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = NM[0];
        M = NM[1];
        makeIf = new IF[N];

        for(int i=0 ; i<N ; i++){
            String[] input = br.readLine().split(" ");
            makeIf[i] = new IF(input[0], Integer.parseInt(input[1]));
        }

        Arrays.sort(makeIf);

        for(int i=0 ; i<M ; i++){
            int point = Integer.parseInt(br.readLine());
            bw.write(check(point) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static String check(int point) {
        int l = 0, r = N-1;


        while(l <= r){
            int mid = (l + r) / 2;

            if(makeIf[mid].point < point){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return makeIf[l].name;
    }
}
