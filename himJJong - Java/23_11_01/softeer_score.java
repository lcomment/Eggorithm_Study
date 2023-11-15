import java.io.*;
import java.util.*;

public class softeer_score {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double[] sum = new double[N];
        st = new StringTokenizer(br.readLine());
        sum[0] = Double.parseDouble(st.nextToken());
        for(int i=1; i<N; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if(a == 0){
                System.out.println(String.format("%.2f", sum[b]/(b-a+1)));
            }
            else{
                System.out.println(String.format("%.2f", (sum[b] - sum[a-1])/(b-a+1)));
            }
        }
    }
}
