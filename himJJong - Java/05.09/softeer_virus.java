import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer_virus {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int init = Integer.parseInt(st.nextToken());
        int plus = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        long answer  = init;
        for(int i = 1; i <= time; i++) {
            answer = (answer * plus) % 1000000007;
        }

        System.out.println(answer);
    }
}
