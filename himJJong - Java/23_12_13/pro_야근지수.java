import java.util.*;
public class pro_야근지수 {
    public static void main(String[] args) {
        int[] words = {1,2,3};
        System.out.println(Solution.solution(3,words));
    }
    static class Solution {
        public static long solution(int n, int[] works) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<works.length; i++){
                pq.add(works[i]);
            }

            while(n-- >0){
                int tmp = 0;
                if(!pq.isEmpty()){
                    tmp = pq.poll()-1;
                }
                if(tmp !=0){
                    pq.add(tmp);
                }
            }

            if(pq.isEmpty())    return 0;

            long answer = 0;
            while(!pq.isEmpty()){
                answer += Math.pow(pq.poll(),2);
            }


            return answer;
        }
    }
}
