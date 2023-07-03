import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15810 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int staff = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] time = new int[staff];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<staff; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);


        long low = 0;
        long right = (long) time[0] * goal;

        while(low <= right){
            long mid = ((low + right) >> 1);
            long check = 0;
            for(int i=0; i<staff; i++){
                check += mid/time[i];
            }

            if(check < goal){
                low = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(low);
    }
}
