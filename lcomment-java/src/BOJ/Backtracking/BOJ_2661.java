package BOJ.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = stoi(br.readLine());

        backtracking("", 0);
    }

    private static void backtracking(String niceSeq, int depth) {
        if(depth == N) {
            System.out.println(niceSeq);
            System.exit(0);
        }

        for(int i=1 ; i<=3 ; i++) {
            if(check(niceSeq + String.valueOf(i))) {
                backtracking(niceSeq + String.valueOf(i), depth + 1);
            }
        }
    }

    private static boolean check(String seq) {
        for(int i=1 ; i<=seq.length()/2 ; i++ ) {
            if(seq.substring(seq.length()-i).equals(seq.substring(seq.length()-2*i,seq.length()-i))) return false;
        }
        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}