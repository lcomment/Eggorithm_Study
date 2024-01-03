import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11286 {
    public static void main(String[] args)throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                }
                else if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                else{
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int cur = Integer.parseInt(br.readLine());

            if(cur != 0){
                pq.add(cur);
            }
            else if(cur == 0 && pq.isEmpty()){
                sb.append(0).append("\n");
            }
            else if(cur == 0 && !pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
