package Programmers.Level2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Programmers_172927 {
    public int solution(int[] picks, String[] minerals) {
        PriorityQueue<MineralSequence> pq = new PriorityQueue<>();
        Queue<Integer> pickSequence = new LinkedList<>();
        int sum = picks[0] + picks[1] + picks[2];

        int cnt;
        for(int i=0 ; i<minerals.length && pq.size() <sum ; i+=5) {
            cnt = 0;
            MineralSequence seq = new MineralSequence();

            while(cnt < 5 && i+cnt < minerals.length) {
                seq.addMineral(minerals[i+cnt]);
                cnt++;
            }
            pq.offer(seq);
        }

        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<picks[i] ; j++) {
                pickSequence.offer(i);
            }
        }

        int result = 0;
        while(!pq.isEmpty() && !pickSequence.isEmpty()) {
            MineralSequence mineral = pq.poll();

            result += mineral.calculateFatigue(pickSequence.poll());
        }

        return result;
    }
}


class MineralSequence implements Comparable<MineralSequence> {
    int diamond, iron, stone;

    MineralSequence() {
        this.diamond = 0;
        this.iron = 0;
        this.stone = 0;
    }

    void addMineral(String mineral) {
        if(mineral.equals("diamond")) this.diamond++;
        else if(mineral.equals("iron")) this.iron++;
        else this.stone++;
    }

    int calculateFatigue(int pick) {
        if(pick == 0) {
            return diamond + iron + stone;
        } else if(pick == 1) {
            return 5 * diamond + iron + stone;
        }
        return stone + 5 * iron + 25 * diamond;
    }

    @Override
    public int compareTo(MineralSequence m) {
        int result = m.diamond - this.diamond;

        if(result == 0) {
            result = m.iron - this.iron;

            if(result == 0) {
                result = m.stone - this.stone;
            }
        }
        return result;
    }
}
