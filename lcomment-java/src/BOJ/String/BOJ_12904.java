package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 뒤에 A 추가 => 뒤에 A 제거
 * 뒤집은 후 뒤에 B 추가 => 뒤에 B 제거 후 뒤집기
 */
public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        if(recursive(S, T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean recursive(String s, String t) {
        if(s.equals(t)) {
            return true;
        }

        StringBuilder sb = new StringBuilder(t);

        if(t.endsWith("A") && recursive(s, t.substring(0, t.length()-1))) {
            return true;
        }
        return t.endsWith("B") && recursive(s, sb.deleteCharAt(t.length() - 1).reverse().toString());
    }
}
