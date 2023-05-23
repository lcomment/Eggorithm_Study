import java.io.*;
import java.util.*;

public class BOJ_10025 {
    static class bowl implements Comparable<bowl>{
        int ice;
        int x;
        bowl(int ice, int x){
            this.ice = ice;
            this.x = x;
        }

        @Override
        public int compareTo(bowl o) {
            return this.x - o.x;
        }
    }
    static List<bowl> list = new ArrayList<>();
    static int answer = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bowl = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        int[] distance = new int[1000001];

        for(int i=0; i<bowl ;i++) {
            st = new StringTokenizer(br.readLine());

            int ice = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(x,max);

            distance[x] = ice;
        }

        int front = 0;
        int end = 0;

        if(max >= limit*2){
            end = limit*2;
            for(int i=0; i<=end ;i++){
                if(distance[i] != 0)    answer += distance[i];
            }
        }
        else if(max < limit*2)  {
            end = max;
            for(int i=0; i<=max; i++){
                if(distance[i] != 0)    answer += distance[i];
            }
            System.out.println(answer);
            System.exit(0);
        }

        int result = answer;

        while(true){
            end++;
            front++;
            if(end > max) break;
            if(distance[end] !=0){
                answer -= distance[front-1];
                answer += distance[end];
                result = Math.max(answer,result);
            }
            else answer -= distance[front-1];
        }
        System.out.println(result);
    }
}
