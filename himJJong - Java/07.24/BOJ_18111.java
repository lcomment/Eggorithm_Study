import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18111 {
    static class Node implements Comparable<Node>{
        int time;
        int height;
        Node(int time, int height){
            this.time = time;
            this.height = height;
        }

        @Override
        public int compareTo(Node o1){
            if(this.time == o1.time) {
                return o1.height - this.height;
            }
            return this.time - o1.time;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();


        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[][] data = new int[row][col];

        for(int i=0; i<row; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<256; i++){  //높이 체크
            int limitData = limit;
            int time = 0;
            for(int j=0; j<row; j++){
                for(int k=0; k<col; k++){
                    int rest = data[j][k] - i;
                    if(rest > 0){   //양수면 1번 작업(제거하여 인벤에 추가) 2초
                        time += 2 * rest;
                        limitData += rest;
                    }
                    else if(rest < 0){
                        time += Math.abs(rest);
                        limitData -= Math.abs(rest);
                    }
                }
            }
            if(limitData >= 0)  pq.offer(new Node(time,i));
        }

        Node tmp = pq.poll();

        System.out.println(tmp.time+" "+tmp.height);
    }
}
