import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static int k;
    static String s, t;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        k = t.length();
        result = dfs(s, t);

        System.out.println(result);
    }

    public static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            ans += dfs(s, string);
        }

        if (t.charAt(t.length() - 1) == 'A') {              // 맨뒤가 A라면
            ans += dfs(s, t.substring(0, t.length() - 1));  // 0 ~ 맨뒤앞까지 잘라서 dfs()
        }

        return ans > 0 ? 1 : 0;
    }
}