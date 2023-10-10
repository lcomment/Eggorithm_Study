import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static sun.nio.ch.IOStatus.check;

public class BOJ_13702 {
    static int N;
    static int K;
    static int[] data;
    static long answer = Long.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N];

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }

        if(N == 0){
            System.out.println(0);
            System.exit(0);
        }
        else if(N==1){
            System.out.println(data[0] / K);
            System.exit(0);
        }

        Arrays.sort(data);
        long left = 0;
        long right = data[N-1];
        while(left <= right){
            long mid = (left + right)/2;
            long tmp = checkVal(mid);

            if(tmp < K){
                right = mid -1;
            }
            else if(tmp >= K){
                left = mid + 1;
            }
        }
        System.out.println(left-1);
    }

    private static long checkVal(long mid) {
        long result = 0;

        for(int i=0; i<N; i++){
            result += data[i]/mid;
        }
        return result;
    }
}
