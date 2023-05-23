package Programmers.Level2;

/**
 * 두 원 사이의 정수 쌍
 */
public class Programmers_181187 {
    public long solution(int r1, int r2) {
        long answer = 0, minY = r1, maxY = r2;

        for(int r=0 ; r<r2 ; r++) {
            while(pow(r2) < pow(maxY) + pow(r)) { maxY -= 1; }
            while(minY -1 > 0 && pow(r1) <= pow(minY-1) + pow(r)) { minY -= 1; }

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }

    private long pow(long num){
        return (long) Math.pow(num, 2);
    }
}
