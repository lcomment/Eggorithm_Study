import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 1;
        int sum = 0;
        int answer = 0;

        if(N == 1){
            if(data[0] == M){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
            System.exit(0);
        }
        sum += data[0];

        for(int i=0; i<N; i++){
            if(sum == M)    {
                answer++;
                sum -= data[i];
                continue;
            }
            while(sum <= M && r < N){
                sum += data[r];
                if(sum == M)    {
                    answer++;
                    r++;
                    break;
                }
                r++;
            }
            sum -= data[i];
        }

        System.out.println(answer);
    }
}
