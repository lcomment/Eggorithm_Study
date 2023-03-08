import java.util.*;
import java.io.*;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] NM;

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] data = new int[NM[0]];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) plus.add(data[i]);
            else if (data[i] < 0) minus.add(Math.abs(data[i]));
        }

        int index = 0;
        int answer = 0;

        if(plus.isEmpty()) index = minus.peek();
        else if(minus.isEmpty()) index = plus.peek();
        else index = Math.max(minus.peek(), plus.peek());

        while(!plus.isEmpty()){
            answer += plus.peek()*2;
            for(int i=0; i<NM[1]; i++){
                plus.poll();
            }
        }
        while(!minus.isEmpty()){
            answer += minus.peek()*2;
            for(int i=0; i<NM[1]; i++){
                minus.poll();
            }
        }
        answer -= index;
        System.out.println(answer);
    }
}