package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7490 {
    static int N;
    static int[] seq;
    static String[] cmd = {" ", "+", "-"};

    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = sToI(br.readLine());

        while(T-- > 0) {
            N = sToI(br.readLine());
            seq = new int[N];

            for(int i=0 ; i<N ; i++){
                seq[i] = i+1;
            }
            backtracking("", 0);
            System.out.println();
        }
    }

    static void backtracking(String s, int idx) {
        s += seq[idx];

        if(idx == N-1) {
            if(calculate(s)) System.out.println(s);
            return;
        }

        for(int i=0 ; i<3 ; i++){
            backtracking(s + cmd[i], idx+1);
        }
    }

    static boolean calculate(String s) {
        s = s.replaceAll(" ", "");

        StringTokenizer st = new StringTokenizer(s, "+|-", true);
        int total = sToI(st.nextToken());

        while(st.hasMoreElements()) {
            String delim = st.nextToken();

            if(delim.equals("+")) total += sToI(st.nextToken());
            if(delim.equals("-")) total -= sToI(st.nextToken());
        }

        return total == 0;
    }

    static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
