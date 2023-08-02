import java.util.ArrayList;
import java.util.List;

public class programmers_문자열밀기 {
    public static void main(String[] args) {
        String A = "hello";
        String B = "ohell";

        int answer = 0;
        String copy = A;

        for (int i = 0; i < A.length(); i++) {
            if (copy.equals(B)) {
                System.out.println(answer);
                System.exit(0);
            }

            String a = copy.substring(copy.length() - 1);
            copy = a + copy.substring(0, copy.length() - 1);
            answer++;
        }

        System.out.println(-1);
    }
}
