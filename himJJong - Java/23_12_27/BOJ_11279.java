import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {
    public static void main(String[] args)throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- >0){
            int cur = Integer.parseInt(br.readLine());

            if(cur == 0 && pq.isEmpty()){
                sb.append(0).append("\n");
            }

            else if(cur == 0 && !pq.isEmpty()){
                sb.append(pq.poll()).append("\n");
            }
            else{
                pq.add(cur);
            }
        }

        System.out.println(sb);
    }
}
