import java.util.*;

class pro_moreSpicy {
    static class Node implements Comparable<Node> {
        int val;

        Node(int val){
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean flag = false;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(new Node(scoville[i]));
        }

        while(!pq.isEmpty()){
            if(pq.size() <= 1){
                break;
            }

            Node min = pq.poll();
            Node min2 = pq.poll();

            if(min.val >= K){
                flag = true;
                break;
            }
            answer++;
            pq.add(new Node(min.val + (min2.val * 2)));
        }
        if(flag){
            return answer;
        }

        Node last = pq.poll();
        if(last.val >= K){
            return answer;
        }
        return -1;
    }
}