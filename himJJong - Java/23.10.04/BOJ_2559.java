import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = Integer.MIN_VALUE;

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = M-1;
        int sum = 0;

        for(int i=start; i<M; i++){
            sum += data[i];
        }
        answer = Math.max(sum, answer);


        for(int i=start; i<N-M; i++){
            if(end < N){
                sum -= data[i];
                sum += data[++end];
                answer = Math.max(answer, sum);
            }
        }
        System.out.println(answer);
    }
}
