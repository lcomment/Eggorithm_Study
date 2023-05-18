import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ssafy_million {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());

            int[] data = new int[N];
            long answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                data[j] = Integer.parseInt(st.nextToken());
            }

            long max = Long.MIN_VALUE;
            int num = 0;
            long cost = 0;
            for(int j=N-1; j>=0 ; j--){
                if(data[j] > max){
                    answer += ( max *num - cost);
                    max = data[j];
                    cost = 0;
                    num = 0;
                }
                else{
                    cost += data[j];
                    num++;
                }
            }

            answer += (max *num - cost);
            System.out.println("#"+i+" "+ answer);
        }
    }
}
