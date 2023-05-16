package Programmers.Level2;

import java.util.PriorityQueue;

/**
 * 연속된 부분 수열의 합
 */
public class Programmers_178870 {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<SubSequence> pq = new PriorityQueue<>((o1, o2) -> o1.size - o2.size);

        int start, end, sum = sequence[0], length = sequence.length;
        start = end = 0;

        while(start < length && end < length) {
            if(sum == k) { pq.offer(new SubSequence(start, end)); }

            if(sum <= k) {
                end++;
                if(end < length) sum += sequence[end];
            } else {
                sum -= sequence[start];
                start++;
            }
        }

        return new int[]{ pq.peek().start, pq.peek().end };
    }
}

class SubSequence {
    int start, end, size;

    SubSequence(int start, int end) {
        this.start = start;
        this.end = end;
        this.size = end - start + 1;
    }
}