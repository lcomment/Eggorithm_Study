import java.io.*;
import java.util.*;

public class BOJ_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> lo = new ArrayList<>();

        int house = Integer.parseInt(st.nextToken());
        int wifi = Integer.parseInt(st.nextToken());

        for(int i=0; i<house; i++){
            lo.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(lo);

        int left = 0;
        int right = lo.get(lo.size()-1) - lo.get(0);
        int distance = 0;
        int answer = 0;

        while(left <= right){
            int mid = (left+right)/2;
            int start = lo.get(0);
            int count = 1;

            for(int i = 0; i<house; i++) {
                distance = lo.get(i) - start;
                if(distance>=mid){
                    count++;
                    start = lo.get(i);
                }
            }

            if(count >= wifi){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        System.out.println(answer);
    }
}