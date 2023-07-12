package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_148653 {

    public int solution(int storey) {
        return bfs(new Move(storey, 0));
    }

    private int bfs(Move start) {
        Queue<Move> q = new LinkedList<>();
        q.offer(start);
        int result = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            Move m = q.poll();

            if(m.position < 10) {
                result = Math.min(result, m.count + m.position);
                result = Math.min(result, m.count + (10 - m.position + 1));
                continue;
            }

            int div = m.position % 10;

            if(div == 0) {
                q.offer(new Move(m.position / 10, m.count));
                continue;
            }

            q.offer(new Move(m.position / 10, m.count + div));
            q.offer(new Move(m.position / 10 + 1, m.count + (10 - div)));
        }
        return result;
    }
}

class Move {
    int position, count;

    Move(int position, int count) {
        this.position = position;
        this.count = count;
    }
}