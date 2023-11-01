import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12847 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        long max = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, data[i]);
        }

        if(M == 0){
            System.out.println(0);
            System.exit(0);
        }
        else if(M == 1){
            System.out.println(max);
            System.exit(0);
        }

        long result = 0;
        long max1 = Long.MIN_VALUE;
        for(int i=0; i<M; i++){
            result += data[i];
        }

        max1 = Math.max(result, max1);
        for(int i=1; i<=N-M; i++){
            result -= data[i-1];
            result += data[i+M-1];

            max1 = Math.max(max1, result);
        }

        System.out.println(max1);
    }
}
