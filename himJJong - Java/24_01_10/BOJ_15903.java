import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int card = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for(int i=0; i<data.length; i++){
            pq.add((long) data[i]);
        }

        while(m-- >0){
            long sum = pq.poll() + pq.poll();

            pq.add(sum);
            pq.add(sum);
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
