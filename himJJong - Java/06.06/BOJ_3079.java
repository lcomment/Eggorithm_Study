import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,data[i]);
        }

        Arrays.sort(data);

        long result = 0;
        long left = 0;
        long right = (long) max * M;

        while(left <= right){
            long mid = (left + right) >> 1;

            long answer = 0;

            for(int i=0; i<N; i++){
                if(answer >= M) break;
                answer += mid/data[i];
            }

            if(answer >= M){
                result = mid;
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}