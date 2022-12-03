package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522 {
    static int A, minB = Integer.MAX_VALUE;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        A = 0;
        for(int i=0 ; i<input.length() ; i++){
            if(input.charAt(i) == 'a')
                A++;
        }

        for(int i=0 ; i<input.length() ; i++){
            int B = 0;

            for(int j=i ; j<A+i ; j++){
                int idx = j % input.length();

                if(input.charAt(idx) == 'b')
                    B++;
            }
            minB = Math.min(minB, B);
        }
        System.out.println(minB);
    }
}
