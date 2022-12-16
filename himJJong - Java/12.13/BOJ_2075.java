import java.io.*;
import java.util.*;

public class BOJ_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());     //우선순위큐 숫자 큰거부터

        for(int i = 0; i<size; i++){        //데이터 입력받은거 q에 넣고
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<size; j++){
                q.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<size; i++){          // 해당 사이즈일 때 출력
            if(i==size-1) System.out.println(q.poll());
            q.poll();
        }
    }
}