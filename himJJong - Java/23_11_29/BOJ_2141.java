import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2141 {
    static class Node implements Comparable<Node>{
        int loc;
        int val;
        Node(int loc, int val){
            this.loc = loc;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.loc - o.loc;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        long[] sum = new long[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b));
        }
        Collections.sort(list);
        sum[0] = list.get(0).val;

        for(int i=1; i<N; i++){
            sum[i] = sum[i-1] + list.get(i).val;
        }

        long l = 0;
        long r = N-1;
        long answer = Long.MAX_VALUE;
        while(l <= r){
            long mid = (l+r)/2;

            if(sum[(int) mid] >= sum[N-1] - sum[(int) mid]){
                r = mid-1;
                answer = Math.min(answer, list.get((int) mid).loc);
            }
            else{
                l = mid+1;
            }
        }
        System.out.println(answer);
    }
}
