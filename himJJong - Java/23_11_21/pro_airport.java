import java.util.*;
class pro_airport {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long min = 1;
        long max = (long)times[0] * n;

        while(min <=max){
            long mid = (min + max)/2;
            long count = 0;
            for(int i=0; i<times.length; i++){
                count += mid / times[i];
                if(count > n)   break;
            }

            if(count < n){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        return min;
    }
}