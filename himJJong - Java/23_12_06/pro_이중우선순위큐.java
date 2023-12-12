import java.util.*;

public class pro_이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Solution.solution(operations));
    }

    static class Solution {
        public static int[] solution(String[] operations) {
            int[] answer = new int[2];
            HashSet<Integer> set = new HashSet<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> qp = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<operations.length; i++){
                String[] tmp = operations[i].split(" ");

                if(tmp[0].equals("I")){
                    pq.add(Integer.parseInt(tmp[1]));
                    qp.add(Integer.parseInt(tmp[1]));
                }
                else if(tmp[0].equals("D") && (!pq.isEmpty() && !qp.isEmpty())){
                    if(tmp[1].equals("1")){
                        int k = qp.poll();
                        pq.remove(k);

                    }
                    else if(tmp[1].equals("-1")){
                        int k = pq.poll();
                        qp.remove(k);
                    }
                }
            }
            if(qp.isEmpty())
                return new int[] {0, 0};

            return new int[] {qp.peek(), pq.peek()};
        }
    }
}
