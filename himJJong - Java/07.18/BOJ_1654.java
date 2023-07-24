import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int need = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        int max = 0;

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, data[i]);
        }

        long left = 0;
        long right = max;

        while(left <= right){
            long mid = (left+right)/2;
            if(mid == 0){
                System.out.println(1);
                System.exit(0);
            }

            long check = 0;
            for(int i=0; i<N; i++){
                check += data[i] / mid;
            }

            if(check < need){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(left-1);
    }
}
