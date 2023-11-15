import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2258 {
    static class gogi implements Comparable<gogi>{
        int weight;
        int money;
        gogi(int weight, int money){
            this.weight = weight;
            this.money = money;
        }

        @Override
        public int compareTo(gogi o){
            if(this.money == o.money){
                return o.weight - this.weight;
            }
            return this.money - o.money;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int meet = Integer.parseInt(st.nextToken());
        int needs = Integer.parseInt(st.nextToken());

        PriorityQueue<gogi> pq = new PriorityQueue<>();

        for(int i=0; i<meet; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new gogi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        boolean isTrue = false;
        int wholeCost = 0;
        long wholeWeight = 0;
        
        int saveBeforeCost = -1;
        int sameCost = 0;
        
        int answer = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            gogi info = pq.poll();
            
            if(saveBeforeCost != info.money){
                saveBeforeCost = info.money;
                sameCost = 0;
            }
            else{
                sameCost += info.money;
            }
            
            wholeWeight += info.weight;
            wholeCost = info.money;
            
            if(wholeWeight >= needs){
                isTrue = true;
                answer = Math.min(answer, wholeCost + sameCost);
            }
        }


        if(isTrue){
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}
