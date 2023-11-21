class pro_targetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        btk(numbers, target, 0, 0, 0);
        return answer;
    }

    private static void btk(int[] numbers, int target, int count, int sum, int at){
        if(count == numbers.length){
            if(sum == target)   answer++;
            return;
        }

        for(int i = at; i<numbers.length; i++){
            btk(numbers, target, count + 1, sum + numbers[i], i+1);
            btk(numbers, target, count + 1, sum - numbers[i], i+1);
        }
    }
}
/*
import java.util.*;

class Solution {
    static int answer = 0;
    static class Node{
        int pos;
        int sum;
        Node(int pos, int sum){
            this.pos = pos;
            this.sum = sum;
        }
    }
    public int solution(int[] numbers, int target) {
        bfs(numbers, target, 0);
        return answer;
    }

    private static void bfs(int[] numbers, int target, int index)  {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(index, numbers[0]));
        q.add(new Node(index, numbers[0] * -1));

        while(!q.isEmpty()){
            Node tmp = q.poll();

            if(tmp.pos >= numbers.length)   continue;
            if(tmp.pos == numbers.length-1 && tmp.sum == target){
                answer++;
            }

            if(tmp.pos == numbers.length -1){
                continue;
            }
            q.add(new Node(tmp.pos + 1, tmp.sum + numbers[tmp.pos + 1]));
            q.add(new Node(tmp.pos + 1, tmp.sum + (numbers[tmp.pos + 1] * -1)));
        }

    }
}
 */