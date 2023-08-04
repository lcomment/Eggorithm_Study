import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14627 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pa = Integer.parseInt(st.nextToken());
        int chicken = Integer.parseInt(st.nextToken());

        long max = Integer.MIN_VALUE;
        long sum = 0;

        int[] data = new int[pa];
        for(int i=0; i<pa ;i++){
            data[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, data[i]);
            sum += data[i];
        }

        long left = 0;
        long right = max;
        while(left <= right){
            long mid = (left + right) >> 1;
            if(mid == 0){
                right = 1;
                break;
            }
            long count = 0;
            for(int i=0; i<pa; i++){
                count += data[i] / mid;
            }
            if(count < chicken){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(sum - (right * chicken));
    }
}
