import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2303 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());
        int answer = 1;

        int[] count = new int[41];

        count[0] = 1;
        count[1] = 1;
        count[2] = 2;

        for(int i=3; i<=N; i++){
            count[i] = count[i-1] + count[i-2];
        }
        int memory= 0;

        for(int i=1; i<=M; i++){
            int index = Integer.parseInt(br.readLine());
            answer *= count[index-1-memory];
            memory = index;
        }
        answer *= count[N-memory];
        System.out.println(answer);
    }
}
