import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data != 0) {
                st.add(data);
            } else {
                if (st.isEmpty()) {
                    continue;
                } else {
                    st.pop();
                }
            }
        }
        int answer = 0;

        while (!st.isEmpty()) {
            answer += st.pop();
        }
        System.out.println(answer);
    }
}

