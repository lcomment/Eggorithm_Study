package Programmers.KAKAO;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long total = 0;
        long q1Sum = 0;
        
        for(int i=0 ; i<queue1.length ; i++){
            total += (queue1[i] + queue2[i]);
            q1Sum += queue1[i];
            
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        // 최대 횟수가 큐 하나의 초기 크기의 3배를 넘을 수 없음 
        int count = q1.size() * 3;
        total /= 2;
        
        while(q1Sum != total){
            if(count == 0) {
                return -1;
            }
            
            int p;
            
            if(q1Sum > total){
                p = q1.poll();
                q1Sum -= p;
                q2.offer(p);
            } else {
                p = q2.poll();
                q1Sum += p;
                q1.offer(p);
            }
            count--;
        }
        
        return queue1.length * 3 - count;
    }
}
