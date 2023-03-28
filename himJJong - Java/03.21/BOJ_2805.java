import java.util.*;
import java.io.*;

public class BOJ_2805 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCount = Integer.parseInt(st.nextToken());
        List<Integer> data = new ArrayList<>();
        long end = Integer.MIN_VALUE;
        long answer = 0;
        long height = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<treeCount; i++){
            data.add(Integer.parseInt(st.nextToken()));
            end = Math.max(end, data.get(i));
        }

        long start = 0;
        long mid = 0;

        while(start<end){
            long sum = 0;
            mid = (start+end)/2;

            for(int i=0; i<treeCount; i++){
                if(mid <= data.get(i)) sum += data.get(i) - mid;
            }
            if(sum < height) end = mid;
            else start = mid+1;
        }
        System.out.println(start-1);
    }
}
